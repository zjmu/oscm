package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zjm
 * @Description 流动资金占用成本管控目标完成情况分析
 * @date Create in 12:47 2019/6/12
 */
@Data
public class Completion {

    private String itemId;
    private BigDecimal quarterPlanValue;
    private BigDecimal planTotalReduceValue;
    private BigDecimal quarterActualValue;
    private BigDecimal actualTotalReduceValue;
    private BigDecimal totalDifference;
    private Item item;
    private List<ItemDept> itemDept;

}
