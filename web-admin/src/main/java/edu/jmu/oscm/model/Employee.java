package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Employee {
    private BigInteger id;
    private String employeeCode;
    private String simpleCode;
    private String employeeName;
    private String employeeType;
    private String deptCode;
    private String state;
    private Date modifyTime;
}
