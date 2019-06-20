package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Department {
    private BigInteger id;
    private String deptCode;
    private String deptName;
    private String parentDeptCode;
    private Integer level;
    private String state;
    private Date modifyTime;
}
