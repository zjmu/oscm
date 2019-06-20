package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class ItemReduceTarget {

    private int id;
    private BigInteger itemId;
    private String year;
    private String deptCode;
    private String deptName;
    private Double yearPercent;
    private BigDecimal yearValue;
    private BigDecimal lastYearValue;
    private BigDecimal jan;
    private BigDecimal feb;
    private BigDecimal mar;
    private BigDecimal apr;
    private BigDecimal may;
    private BigDecimal jun;
    private BigDecimal jul;
    private BigDecimal aug;
    private BigDecimal sept;
    private BigDecimal oct;
    private BigDecimal nov;
    private BigDecimal dec;
    private Boolean assetOrDebt;
    private Timestamp createDate;
}
