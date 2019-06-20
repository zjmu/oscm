package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class ReportItemInstance {

    private BigInteger id;
    private BigInteger reportItemId;
    private String reportCode;
    private String reportName;
    private String deptCode;
    private String deptName;
    private String itemCode;
    private String itemName;
    private Integer level;
    private String parentItemCode;
    private Integer orderNum;
    private String year;
    private String month;
    private String beginValue;
    private String value;
    private String endValue;
    private Date modifyTime;
    private String itemId;
    private String endValueSum;

}
