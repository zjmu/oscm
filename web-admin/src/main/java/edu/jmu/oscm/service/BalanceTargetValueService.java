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

@Service
public class BalanceTargetValueService {

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    @Autowired
    private IncentiveRatioMapper incentiveRatioMapper;

    @Autowired
    private ReportItemMapper reportItemMapper;

    List<ReportItem> itemReduceTargets;
    public List<BalanceTargetValue> calculate(String year, String month, BigInteger reportId){
        List<ReportItem> thisMonthReportItems = reportItemMapper.getReportItemAndReportItemInstance(reportId,year,month);
        List<BalanceTargetValue> balanceTargetValues = new ArrayList<>();
//        if(reportItems.size()==0)
//            return "请先计算当前月的上月余额与目标降低值!";
        itemReduceTargets = reportItemMapper.getReportItemAndItemReduceTarget(reportId,year);

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
//        if(incentiveRatios.size()>1)
//            return "您设置了多条当年的奖励比例";

        for(ReportItem reportItem:thisMonthReportItems){
            BalanceTargetValue balanceTargetValue = new BalanceTargetValue();
            balanceTargetValue.setItemId(reportItem.getItemId());
            balanceTargetValue.setYear(year);
            balanceTargetValue.setMonth(month);

            BigInteger itemId = balanceTargetValue.getItemId();

            calculateLastMonthBalance(lastMonthReportItems,balanceTargetValue);

            BigDecimal planMonthTargetValue = calculatePlanMonthTargetValue(itemId,month);
            balanceTargetValue.setPlanMonthTargetValue(planMonthTargetValue);

            calculatePlanTotalReduceValue(balanceTargetValue, itemId);

            BigDecimal thisMonthEndValue = new BigDecimal(reportItem.getReportItemInstance().getEndValue());
            BigDecimal actualMonthTargetValue = thisMonthEndValue.subtract(balanceTargetValue.getLastMonthBalance());
            balanceTargetValue.setActualMonthTargetValue(actualMonthTargetValue);

            BigDecimal lastYearEndValue = calculateActualTotalTargetValue(lastYearReportItems,balanceTargetValue,itemId);
            BigDecimal actualTotalReduceValue = thisMonthEndValue.subtract(lastYearEndValue);
            balanceTargetValue.setActualTotalReduceValue(actualTotalReduceValue);

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
        balanceTargetValueMapper.deleteByDate(year, month);
        balanceTargetValueMapper.insertMore(balanceTargetValues);
        return balanceTargetValues;
    }

    public void calculateLastMonthBalance(List<ReportItem> reportItems,BalanceTargetValue balanceTargetValue){
        BigDecimal lastEndValue;
        lastEndValue = findEndValue(reportItems,balanceTargetValue.getItemId());
        balanceTargetValue.setLastMonthBalance(lastEndValue);
    }

    public BigDecimal calculatePlanMonthTargetValue(BigInteger itemId, String month){
        for(ReportItem reportItem:itemReduceTargets ) {
            if(reportItem.getItemId().equals(itemId))
            switch (month) {
                case "01":
                    return reportItem.getItemReduceTarget().getJan();
                case "02":
                    return reportItem.getItemReduceTarget().getFeb();
                case "03":
                    return reportItem.getItemReduceTarget().getMar();
                case "04":
                    return reportItem.getItemReduceTarget().getApr();
                case "05":
                    return reportItem.getItemReduceTarget().getMay();
                case "06":
                    return reportItem.getItemReduceTarget().getJun();
                case "07":
                    return reportItem.getItemReduceTarget().getJul();
                case "08":
                    return reportItem.getItemReduceTarget().getAug();
                case "09":
                    return reportItem.getItemReduceTarget().getSept();
                case "10":
                    return reportItem.getItemReduceTarget().getOct();
                case "11":
                    return reportItem.getItemReduceTarget().getNov();
                case "12":
                    return reportItem.getItemReduceTarget().getDec();
            }
        }
        return BigDecimal.valueOf(0);
    }

    public void calculatePlanTotalReduceValue(BalanceTargetValue balanceTargetValue,BigInteger itemId){
        BigDecimal total=BigDecimal.valueOf(0);
        Integer month = Integer.valueOf(balanceTargetValue.getMonth());
        String mon="";
        for(int i=1;i<=month;i++){
            if(i<10)
                mon="0"+String.valueOf(i);
            else
                mon=String.valueOf(i);
            BigDecimal result = calculatePlanMonthTargetValue(itemId,mon);
            total = total.add(result);
        }
        balanceTargetValue.setPlanTotalReduceValue(total);
    }

    public BigDecimal calculateActualTotalTargetValue(List<ReportItem> lastYearReportItems,BalanceTargetValue balanceTargetValue,BigInteger itemId){
        BigDecimal lastYearEndValue = new BigDecimal("0");
        for (ReportItem reportItem: lastYearReportItems){
            if(reportItem.getItemId().equals(itemId))
                lastYearEndValue = new BigDecimal(reportItem.getReportItemInstance().getEndValue());
        }

        return lastYearEndValue;
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

}
