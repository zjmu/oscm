package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class IncentiveRatio {

    private Integer id;
    private String year;
    private String deptCode;
    private String deptName;
    private BigDecimal interestRate;
    private BigDecimal incentiveRatio;
    private BigDecimal maxLimit;
    private Timestamp createDate;

}
