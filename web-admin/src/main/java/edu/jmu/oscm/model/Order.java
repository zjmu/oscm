package edu.jmu.oscm.model;

import lombok.Data;

/**
 * 订单类
 *
 * @author guantianmin
 * @date 2019/3/12 20:11
 */
@Data
public class Order {
    private Long id;
    private String name;
    private Integer goodsNum;
}
