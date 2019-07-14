package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zjm
 * @Description 动资金占用成本管控增创价值表
 * @date Create in 12:51 2019/6/12
 */
@Data
public class IncrementalValue {

    private BigDecimal quarterActualTargetValue;
    private BigDecimal actualTotalReduceValue;
    private BigDecimal quarterIncrementalValue;
    private BigDecimal totalIncrementalValue;
    private List<ItemDept> itemDept;
    private Item item;

}
