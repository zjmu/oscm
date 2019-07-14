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

    public List<BalanceTargetValue> calculate(String year, String month, BigInteger reportId,String deptCode){
        //获取所需的全部表的数据
        List<ItemReduceTarget> itemReduceTargets = reportItemMapper.getItemReduceTarget(reportId,year,deptCode);
        List<ReportItem> thisMonthReportItemInstances = reportItemMapper.getReportItemAndReportItemInstance(reportId,year,month,deptCode);
        List<ReportItem> lastYearReportItemInstances = reportItemMapper.getReportItemAndReportItemInstance(reportId,String.valueOf(Integer.parseInt(year) - 1),"12",deptCode);
        IncentiveRatio incentiveRatios = incentiveRatioMapper.select(year,deptCode);
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
        List<ReportItem> lastMonthReportItemInstances = reportItemMapper.getReportItemAndReportItemInstance(reportId,lastYear,lastMonth,deptCode);

        //获取累计减低占用
        List<PlanTotalReduceValue> planTotalReduceValues;
        if(Integer.valueOf(month)>=3){//不跨年
            Integer monthValue=Integer.valueOf(month)-2;
            planTotalReduceValues=reportItemMapper.getSameYearPlanTotalTargetValue(reportId,year,monthValue,deptCode);
        }
        else {//跨年
            String lastYear1=String.valueOf(Integer.valueOf(year)-1);
            Integer monthValue=Integer.valueOf(month);
            planTotalReduceValues=reportItemMapper.getDifferentYearPlanTotalTargetValue(reportId,year,lastYear1,monthValue,deptCode);
        }

        List<BalanceTargetValue> balanceTargetValues = new ArrayList<>();
        for(ReportItem thisMonthReportItemInstance: thisMonthReportItemInstances){
            BalanceTargetValue balanceTargetValue = new BalanceTargetValue();
            BigInteger itemId=thisMonthReportItemInstance.getItemId();

            //基本信息赋值
            balanceTargetValue.setItemId(itemId);
            balanceTargetValue.setYear(year);
            balanceTargetValue.setMonth(month);
            balanceTargetValue.setDeptCode(thisMonthReportItemInstance.getReportItemInstance().getDeptCode());
            balanceTargetValue.setDeptName(thisMonthReportItemInstance.getReportItemInstance().getDeptName());
            //计算上月期末余额值
            calculateLastMonthBalance(lastMonthReportItemInstances,balanceTargetValue,itemId);
            //计算当月占用降低
            calculatePlanTargetValue(balanceTargetValue,itemReduceTargets,itemId);

            //计算累计占用降低
            calculatePlanTotalTargetValue(balanceTargetValue,planTotalReduceValues,itemId);
            //计算本月实际降低值,获取本月期末余额减去上月期末余额
            BigDecimal thisMonthEndValue = new BigDecimal(thisMonthReportItemInstance.getReportItemInstance().getEndValue());
            BigDecimal actualMonthTargetValue = thisMonthEndValue.subtract(balanceTargetValue.getLastMonthBalance());
            balanceTargetValue.setActualMonthTargetValue(actualMonthTargetValue);
            //计算累计实际降低值，本月期末余额减去上一年12月份期末余额
            calculateActualTotalTargetValue(lastYearReportItemInstances,balanceTargetValue,new BigDecimal(thisMonthReportItemInstance.getReportItemInstance().getEndValue()),itemId);
            //计算增创价值和奖励金额
            calculateIncrementalValueAndReward(incentiveRatios,balanceTargetValue);
            //获取计算时间
            Date date = new Date();
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            Timestamp now = Timestamp.valueOf(nowTime);
            balanceTargetValue.setCreateDate(now);

            balanceTargetValues.add(balanceTargetValue);
        }
        balanceTargetValueMapper.insertMore(balanceTargetValues);
        return balanceTargetValues;
    }

    public void calculateLastMonthBalance(List<ReportItem> reportItemInstances,BalanceTargetValue balanceTargetValue,BigInteger itemId){
        //寻找ITEM_ID相同的项计算
        for(ReportItem reportItemInstance:reportItemInstances){
            if(reportItemInstance.getItemId().equals(itemId)){
                balanceTargetValue.setLastMonthBalance(new BigDecimal(reportItemInstance.getReportItemInstance().getEndValue()));
                break;
            }
        }
    }

    public void calculatePlanTargetValue(BalanceTargetValue balanceTargetValue, List<ItemReduceTarget> itemReduceTargets,BigInteger itemId){
        BigDecimal planMonthTargetValue = new BigDecimal("0");
        BigDecimal planTotalReduceValue = new BigDecimal("0");
        for(ItemReduceTarget itemReduceTarget:itemReduceTargets) {
            //找到对应部门后同时获取当月和总的计划余额
            if(itemReduceTarget.getItemId().equals(itemId)) {
                planMonthTargetValue=findPlanTargetValue(itemReduceTarget,balanceTargetValue.getMonth());
                //获取总的计划余额
//                Integer month = Integer.valueOf(balanceTargetValue.getMonth());
//                for(int i=1;i<=month;i++){
//                    String mon="";
//                    if(i<10)
//                        mon="0"+String.valueOf(i);
//                    else
//                        mon=String.valueOf(i);
//                    planTotalReduceValue = planTotalReduceValue.add(findPlanTargetValue(itemReduceTarget, mon));
//                }
                break;
            }
        }
        balanceTargetValue.setPlanMonthTargetValue(planMonthTargetValue);
        balanceTargetValue.setPlanTotalReduceValue(planTotalReduceValue);
    }


    public void calculateActualTotalTargetValue(List<ReportItem> lastYearReportItemInstances,BalanceTargetValue balanceTargetValue,BigDecimal thisMonthEndValue,BigInteger itemId){
        BigDecimal lastYearEndValue = new BigDecimal("0");
        //按部门获得要计算数值
        for (ReportItem reportItemInstance: lastYearReportItemInstances){
            if(reportItemInstance.getItemId().equals(itemId)){
                lastYearEndValue = new BigDecimal(reportItemInstance.getReportItemInstance().getEndValue());
                break;
            }
        }

        BigDecimal actualTotalReduceValue = thisMonthEndValue.subtract(lastYearEndValue);
        balanceTargetValue.setActualTotalReduceValue(actualTotalReduceValue);
    }

    public void calculateIncrementalValueAndReward(IncentiveRatio incentiveRatio, BalanceTargetValue balanceTargetValue){

        BigDecimal rate = new BigDecimal("0");
        BigDecimal ratio = new BigDecimal("0");
        rate = incentiveRatio.getInterestRate();
        ratio = incentiveRatio.getIncentiveRatio();


        BigDecimal monthIncrementalValue = balanceTargetValue.getActualMonthTargetValue().multiply(rate);
        BigDecimal totalIncrementalValue = balanceTargetValue.getActualTotalReduceValue().multiply(rate);
        BigDecimal monthReward = monthIncrementalValue.multiply(ratio);
        BigDecimal totalReward = totalIncrementalValue.multiply(ratio);

        balanceTargetValue.setMonthIncrementalValue(monthIncrementalValue);
        balanceTargetValue.setTotalIncrementalValue(totalIncrementalValue);
        balanceTargetValue.setMonthReward(monthReward);
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

    public void calculatePlanTotalTargetValue(BalanceTargetValue balanceTargetValue,List<PlanTotalReduceValue> planTotalReduceValues,BigInteger itemId){
        for(PlanTotalReduceValue planTotalReduceValue:planTotalReduceValues){
            if(planTotalReduceValue.getItemId().equals(itemId)){
                balanceTargetValue.setPlanTotalReduceValue(planTotalReduceValue.getPlanTotalReduceValue());
            }
        }
    }

}
