package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author zjm
 * @date 2019/7/14
 */
@Data
public class PlanTotalReduceValue {
    private BigInteger itemId;
    private BigDecimal planTotalReduceValue;
}
