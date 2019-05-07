package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ValueCreation {

    private Integer id;
    private BigInteger reportItemId;
    private String year;
    private String month;
    private BigDecimal lowerTarget;
    private BigDecimal totalLowerTarget;
    private BigDecimal realLowerTarget;
    private BigDecimal realTotalLowerTarget;
    private BigDecimal difference;
    private String date;

}
