package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zjm
 * @Description 目标匹配表
 * @date Create in 12:41 2019/6/12
 */
@Data
public class TargetMatching {

    private String parentItemCode;
    private BigDecimal lastQuarterEndValue;
    private BigDecimal quarterTargetValue;
    private List<ItemEmployee> itemEmployee;
    private Item item;
}
