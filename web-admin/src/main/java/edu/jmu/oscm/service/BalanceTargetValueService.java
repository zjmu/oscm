package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.*;
import edu.jmu.oscm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description 先按ItemId对各个表格进行划分，再在相同的ItemId下取相应部门进行计算，返回泛型数组，再取下一个ItemId继续计算
 * @author zjm
 */
@Service
public class BalanceTargetValueService {

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    @Autowired
    private IncentiveRatioMapper incentiveRatioMapper;

    @Autowired
    private ReportItemMapper reportItemMapper;

    public List<BalanceTargetValue> calculate(String year, String month, BigInteger reportId){
        List<ReportItem> reportItemAndItemReduceTargets = reportItemMapper.getReportItemAndItemReduceTarget(reportId,year);
        List<ReportItem> thisMonthReportItems = reportItemMapper.getReportItemAndReportItemInstance(reportId,year,month);
        List<BalanceTargetValue> balanceTargetValues = new ArrayList<>();

        String lastYear;
        String lastMonth;
        if(month.equals("01")){
            lastYear = String.valueOf(Integer.parseInt(year) - 1);
            lastMonth = "12";
        }
        else {
            lastYear = year;
            lastMonth = String.valueOf(Integer.parseInt(month) - 1);
            if(lastMonth.length()<2)
                lastMonth="0"+lastMonth;
        }

        List<ReportItem> lastMonthReportItems = reportItemMapper.getReportItemAndReportItemInstance(reportId,lastYear,lastMonth);

        List<ReportItem> lastYearReportItems = reportItemMapper.getReportItemAndReportItemInstance(reportId,String.valueOf(Integer.parseInt(year) - 1),"12");

        List<IncentiveRatio> incentiveRatios = incentiveRatioMapper.select(year);

        for(ReportItem thisMonthReportItem:thisMonthReportItems){
            List<ReportItemInstance> thisMonthReportItemInstances = thisMonthReportItem.getReportItemInstances();
            List<ReportItemInstance> lastMonthReportItemInstances = new ArrayList<>();
            List<ReportItemInstance> lastYearReportItemInstances = new ArrayList<>();
            List<ItemReduceTarget> itemReduceTargets = new ArrayList<>();

            //先对ItemId进行筛选
            for(ReportItem lastMonthReportItem:lastMonthReportItems){
                if(lastMonthReportItem.getItemId().equals(thisMonthReportItem.getItemId()))
                     lastMonthReportItemInstances = lastMonthReportItem.getReportItemInstances();
            }
            for(ReportItem lastYearReportItem:lastYearReportItems){
                if(lastYearReportItem.getItemId().equals(thisMonthReportItem.getItemId()))
                    lastYearReportItemInstances = lastYearReportItem.getReportItemInstances();
            }

            for(ReportItem reportItem:reportItemAndItemReduceTargets){
                if(reportItem.getItemId().equals(thisMonthReportItem.getItemId()))
                    itemReduceTarget = reportItem.getItemReduceTarget();
            }

            calculateByItemId(thisMonthReportItemInstances,lastMonthReportItemInstances,lastYearReportItemInstances,
                    itemReduceTarget,incentiveRatios,thisMonthReportItem.getItemId(),year,month);

        }
        balanceTargetValueMapper.deleteByDate(year, month);
        balanceTargetValueMapper.insertMore(balanceTargetValues);
        return balanceTargetValues;
    }

    public List<BalanceTargetValue> calculateByItemId(List<ReportItemInstance> thisMonthReportItemInstances, List<ReportItemInstance> lastMonthReportItemInstances
            , List<ReportItemInstance> lastYearReportItemInstances,List<ItemReduceTarget> itemReduceTargets,List<IncentiveRatio> incentiveRatios,
            BigInteger itemId,String year,String month){

        List<BalanceTargetValue> balanceTargetValues;
        for(ReportItemInstance thisMonthReportItemInstance: thisMonthReportItemInstances){
            BalanceTargetValue balanceTargetValue = new BalanceTargetValue();
            balanceTargetValue.setItemId(itemId);
            balanceTargetValue.setYear(year);
            balanceTargetValue.setMonth(month);
            balanceTargetValue.setDeptCode(thisMonthReportItemInstance.getDeptCode());
            balanceTargetValue.setDeptName(thisMonthReportItemInstance.getDeptName());

            //计算上月期末余额值
            calculateLastMonthBalance(lastMonthReportItemInstances,balanceTargetValue);

            //计算当月及总的计划降低值
            calculatePlanTargetValue(balanceTargetValue,itemReduceTargets);

            //计算本月实际降低值,获取本月期末余额减去上月期末余额
            BigDecimal thisMonthEndValue = new BigDecimal(thisMonthReportItemInstance.getEndValue());
            BigDecimal actualMonthTargetValue = thisMonthEndValue.subtract(balanceTargetValue.getLastMonthBalance());
            balanceTargetValue.setActualMonthTargetValue(actualMonthTargetValue);

            //计算累计实际降低值，本月期末余额减去上一年12月份期末余额
            calculateActualTotalTargetValue(lastYearReportItemInstances,balanceTargetValue,new BigDecimal(thisMonthReportItemInstance.getEndValue()));

            calculateMonthIncremental(incentiveRatios.get(0),balanceTargetValue);

            calculateTotalIncremental(incentiveRatios.get(0),balanceTargetValue);

            calculateMonthReward(incentiveRatios.get(0),balanceTargetValue);

            calculateTotalReward(incentiveRatios.get(0),balanceTargetValue);

            Date date = new Date();
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            Timestamp now = Timestamp.valueOf(nowTime);
            balanceTargetValue.setCreateDate(now);

            balanceTargetValues.add(balanceTargetValue);
        }
    }

    public void calculateLastMonthBalance(List<ReportItemInstance> reportItemInstances,BalanceTargetValue balanceTargetValue){
        for(ReportItemInstance reportItemInstance:reportItemInstances){
            if(reportItemInstance.getDeptCode().equals(balanceTargetValue.getDeptCode()))
                balanceTargetValue.setLastMonthBalance(new BigDecimal(reportItemInstance.getEndValue()));
        }
    }

    public void calculatePlanTargetValue(BalanceTargetValue balanceTargetValue, List<ItemReduceTarget> itemReduceTargets){
        BigDecimal planMonthTargetValue = new BigDecimal("0");
        BigDecimal planTotalReduceValue = new BigDecimal("0");
        for(ItemReduceTarget itemReduceTarget:itemReduceTargets) {
            //找到对应部门后同时获取当月和总的计划余额
            if(itemReduceTarget.getDeptCode().equals(balanceTargetValue.getDeptCode())) {
                planMonthTargetValue=findPlanTargetValue(itemReduceTarget,balanceTargetValue.getMonth());

                //获取总的计划余额
                Integer month = Integer.valueOf(balanceTargetValue.getMonth());
                for(int i=1;i<=month;i++){
                    String mon="";
                    if(i<10)
                        mon="0"+String.valueOf(i);
                    else
                        mon=String.valueOf(i);
                    planTotalReduceValue.add(findPlanTargetValue(itemReduceTarget, mon));
                }
            }
        }

        balanceTargetValue.setPlanMonthTargetValue(planMonthTargetValue);
        balanceTargetValue.setPlanTotalReduceValue(planTotalReduceValue);
    }

    public void calculatePlanTotalReduceValue(BalanceTargetValue balanceTargetValue,BigInteger itemId){

    }

    public void calculateActualTotalTargetValue(List<ReportItemInstance> lastYearReportItemInstances,BalanceTargetValue balanceTargetValue,BigDecimal thisMonthEndValue){
        BigDecimal lastYearEndValue = new BigDecimal("0");
        //按部门获得要计算数值
        for (ReportItemInstance reportItemInstance: lastYearReportItemInstances){
            if(reportItemInstance.getDeptCode().equals(balanceTargetValue.getDeptCode()))
                lastYearEndValue = new BigDecimal(reportItemInstance.getEndValue());
        }

        BigDecimal actualTotalReduceValue = thisMonthEndValue.subtract(lastYearEndValue);
        balanceTargetValue.setActualTotalReduceValue(actualTotalReduceValue);
    }

    public BigDecimal findEndValue(List<ReportItem> reportItems,BigInteger itemId){
        BigDecimal endValue = new BigDecimal("0");
        for(ReportItem reportItem:reportItems){
            if(reportItem.getItemId().equals(itemId)){
                if(reportItem.getReportItemInstance().getEndValue()!=null)
                    endValue = new BigDecimal(reportItem.getReportItemInstance().getEndValue());
                else
                    endValue = new BigDecimal("0");
            }
        }
        return endValue;
    }

    public void calculateMonthIncremental(IncentiveRatio incentiveRatio, BalanceTargetValue balanceTargetValue){

        BigDecimal actualMonthTargetValue = balanceTargetValue.getActualMonthTargetValue();
        BigDecimal rate = incentiveRatio.getInterestRate();
        BigDecimal monthIncrementalValue = actualMonthTargetValue.multiply(rate);

        balanceTargetValue.setMonthIncrementalValue(monthIncrementalValue);
    }

    public void calculateTotalIncremental(IncentiveRatio incentiveRatio, BalanceTargetValue balanceTargetValue){

        BigDecimal actualTotalTargetValue = balanceTargetValue.getActualTotalReduceValue();
        BigDecimal rate = incentiveRatio.getInterestRate();
        BigDecimal totalIncrementalValue = actualTotalTargetValue.multiply(rate);

        balanceTargetValue.setTotalIncrementalValue(totalIncrementalValue);
    }

    public void calculateMonthReward(IncentiveRatio incentiveRatio, BalanceTargetValue balanceTargetValue){

        BigDecimal monthIncrementalValue = balanceTargetValue.getMonthIncrementalValue();
        BigDecimal ratio = incentiveRatio.getIncentiveRatio();
        BigDecimal monthReward = monthIncrementalValue.multiply(ratio);

        balanceTargetValue.setMonthReward(monthReward);
    }

    public void calculateTotalReward(IncentiveRatio incentiveRatio, BalanceTargetValue balanceTargetValue){

        BigDecimal totalIncrementalValue = balanceTargetValue.getTotalIncrementalValue();
        BigDecimal ratio = incentiveRatio.getIncentiveRatio();
        BigDecimal totalReward = totalIncrementalValue.multiply(ratio);

        balanceTargetValue.setTotalReward(totalReward);
    }

    public BigDecimal findPlanTargetValue(ItemReduceTarget itemReduceTarget, String month){
        switch (month) {
            case "01":
                return itemReduceTarget.getJan();
            case "02":
                return itemReduceTarget.getFeb();
            case "03":
                return itemReduceTarget.getMar();
            case "04":
                return itemReduceTarget.getApr();
            case "05":
                return itemReduceTarget.getMay();
            case "06":
                return itemReduceTarget.getJun();
            case "07":
                return itemReduceTarget.getJul();
            case "08":
                return itemReduceTarget.getAug();
            case "09":
                return itemReduceTarget.getSept();
            case "10":
                return itemReduceTarget.getOct();
            case "11":
                return itemReduceTarget.getNov();
            case "12":
                return itemReduceTarget.getDec();
        }
        return new BigDecimal("0");
    }

}
