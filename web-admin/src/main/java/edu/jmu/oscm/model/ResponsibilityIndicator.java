package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zjm
 * @Description 流动资金占用成本管控责任关键指标
 * @date Create in 12:50 2019/6/12
 */
@Data
public class ResponsibilityIndicator {

    private BigDecimal lastMonthBalance;
    private BigDecimal planMonthTargetValue;
    private ItemEmployee itemEmployee;
    private List<ItemDept> itemDepts;
    private List<ItemEmployee> itemEmployees;
    private Item item;

}
