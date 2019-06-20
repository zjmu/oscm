package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ItemEmployee {
    private Integer id;
    private BigInteger itemId;
    private Integer isCharge;
    private BigInteger employeeId;
    private Employee employee;

}
