package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Data
public class BalanceTargetValue {

    private Integer id;
    private BigInteger itemId;
    private String deptCode;
    private String deptName;
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
    private Timestamp createDate;
    private Item item;
    private List<ItemDept> itemDept;
    private List<ItemEmployee> itemEmployee;

}
