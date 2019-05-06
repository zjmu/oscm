package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class BalanceTargetValue {

    private Integer id;
    private BigInteger reportItemId;
    private String year;
    private String month;
    private BigDecimal lastMonthBalance;
    private BigDecimal planMonthTargetValue;
    private BigDecimal planTotalReduceValue;
    private BigDecimal actualMonthTargetValue;
    private BigDecimal actualTotalReduceValue;
    private BigDecimal monthIncrementalValue;
    private BigDecimal totalIncrementalValue;
    private BigDecimal monthReward;
    private BigDecimal totalReward;
    private String date;

}
