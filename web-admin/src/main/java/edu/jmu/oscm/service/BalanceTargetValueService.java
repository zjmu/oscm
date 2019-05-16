package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.BalanceTargetValueMapper;
import edu.jmu.oscm.mapper.CalculateBalanceTargetMapper;
import edu.jmu.oscm.mapper.IncentiveRatioMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.IncentiveRatio;
import edu.jmu.oscm.model.ItemReduceTarget;
import edu.jmu.oscm.model.ReportItemInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BalanceTargetValueService {

    @Autowired
    private CalculateBalanceTargetMapper calculateBalanceTargetMapper;
    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;
    @Autowired
    private IncentiveRatioMapper incentiveRatioMapper;

    List<ItemReduceTarget> itemReduceTargets;
    public String calculate(String year, String month){
        //获取表基本结构
        List<BalanceTargetValue> balanceTargetValues = calculateBalanceTargetMapper.selectBasicTable(year,month);
        if(balanceTargetValues.size()==0)
            return "请先计算当前月的上月余额与目标降低值!";
        itemReduceTargets = calculateBalanceTargetMapper.selectItemReduceTarget(year);

        String lastYear;
        String lastMonth;
        if(month.equals("1")){
            lastYear = String.valueOf(Integer.parseInt(year) - 1);
            lastMonth = "12";
        }
        else {
            lastYear = year;
            lastMonth = String.valueOf(Integer.parseInt(month) - 1);
        }

        List<ReportItemInstance> lastMonthBalances = calculateBalanceTargetMapper.selectEndValue(lastYear,lastMonth);

        List<ReportItemInstance> thisMonthBalances = calculateBalanceTargetMapper.selectEndValue(year,month);

        List<ReportItemInstance> firstMonthBalances = calculateBalanceTargetMapper.selectEndValue(String.valueOf(Integer.parseInt(year) - 1),"12");

        List<IncentiveRatio> incentiveRatios = incentiveRatioMapper.select(year);
        if(incentiveRatios.size()>1)
            return "您设置了多条当年的奖励比例";

        for(BalanceTargetValue balanceTargetValue: balanceTargetValues){
            BigInteger reportItemId = balanceTargetValue.getReportItemId();

            calculateLastMonthBalance(lastMonthBalances,balanceTargetValue);

            BigDecimal planMonthTargetValue = calculatePlanMonthTargetValue(reportItemId,month);
            balanceTargetValue.setPlanMonthTargetValue(planMonthTargetValue);

            calculatePlanTotalReduceValue(balanceTargetValue);

            BigDecimal actualMonthTargetValue = calculateActualTargetValue(thisMonthBalances,lastMonthBalances,reportItemId);
            balanceTargetValue.setActualMonthTargetValue(actualMonthTargetValue);

            BigDecimal actualTotalTargetValue = calculateActualTargetValue(thisMonthBalances,firstMonthBalances,reportItemId);
            balanceTargetValue.setActualTotalReduceValue(actualTotalTargetValue);

            calculateMonthIncremental(incentiveRatios.get(0),balanceTargetValue);

            calculateTotalIncremental(incentiveRatios.get(0),balanceTargetValue);

            calculateMonthReward(incentiveRatios.get(0),balanceTargetValue);

            calculateTotalReward(incentiveRatios.get(0),balanceTargetValue);

            Date date = new Date();
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            Timestamp now = Timestamp.valueOf(nowTime);
            balanceTargetValue.setCreateDate(now);
        }
        balanceTargetValueMapper.insertMore(balanceTargetValues);
        return "计算完成!";
    }

    public void calculateLastMonthBalance(List<ReportItemInstance> reportItemInstances,BalanceTargetValue balanceTargetValue){
        BigDecimal lastEndValue = BigDecimal.valueOf(0);
        for(ReportItemInstance reportItemInstance :reportItemInstances){
            if(reportItemInstance.getReportItemId() == balanceTargetValue.getReportItemId()){
                lastEndValue = new BigDecimal(reportItemInstance.getEndValue());
            }
        }
        balanceTargetValue.setLastMonthBalance(lastEndValue);
    }

    public BigDecimal calculatePlanMonthTargetValue(BigInteger reportItemId, String month){
        for(ItemReduceTarget itemReduceTarget:itemReduceTargets ) {
            if(itemReduceTarget.getReportItemId() == reportItemId)
            switch (month) {
                case "1":
                    return itemReduceTarget.getJan();
                case "2":
                    return itemReduceTarget.getFeb();
                case "3":
                    return itemReduceTarget.getMar();
                case "4":
                    return itemReduceTarget.getApr();
                case "5":
                    return itemReduceTarget.getMay();
                case "6":
                    return itemReduceTarget.getJun();
                case "7":
                    return itemReduceTarget.getJul();
                case "8":
                    return itemReduceTarget.getAug();
                case "9":
                    return itemReduceTarget.getSept();
                case "10":
                    return itemReduceTarget.getOct();
                case "11":
                    return itemReduceTarget.getNov();
                case "12":
                    return itemReduceTarget.getDec();
            }
        }
        return BigDecimal.valueOf(0);
    }

    public void calculatePlanTotalReduceValue(BalanceTargetValue balanceTargetValue){
        BigDecimal total=BigDecimal.valueOf(0);
        Integer month = Integer.valueOf(balanceTargetValue.getMonth());
        for(int i=1;i<=month;i++){
            BigInteger reportItemId = balanceTargetValue.getReportItemId();
            BigDecimal result = calculatePlanMonthTargetValue(reportItemId,String.valueOf(i));
            total = total.add(result);
        }
        balanceTargetValue.setPlanTotalReduceValue(total);
    }

    public BigDecimal calculateActualTargetValue(List<ReportItemInstance>MonthBalances1,List<ReportItemInstance>MonthBalances2,BigInteger reportItemId){
        BigDecimal thisMonthValue = new BigDecimal("0");
        BigDecimal firstMonthValue = new BigDecimal("0");
        BigDecimal actualTargetValue;

        for(ReportItemInstance MonthBalance:MonthBalances1){
            if(MonthBalance.getReportItemId() == reportItemId){
                thisMonthValue = new BigDecimal(MonthBalance.getEndValue());
            }
        }

        for(ReportItemInstance MonthBalance:MonthBalances2){
            if(MonthBalance.getReportItemId() == reportItemId){
                firstMonthValue = new BigDecimal(MonthBalance.getEndValue());
            }
        }
        actualTargetValue = thisMonthValue.subtract(firstMonthValue);
        return actualTargetValue;
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
