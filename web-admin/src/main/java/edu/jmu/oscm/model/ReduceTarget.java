package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class ReduceTarget {
    //主键
    private int id;
    //报告条目id
    private BigInteger item_id;
    //年份
    private String year;
    //年度百分比，单位%
    private Double year_percent;
    //计算后的年目标值
    private BigDecimal year_value;
    //去年实际降低额
    private BigDecimal last_year_value;
    //一月份到十二月份
    private BigDecimal jan;
    private BigDecimal feb;
    private BigDecimal mar;
    private BigDecimal apr;
    private BigDecimal may;
    private BigDecimal jun;
    private BigDecimal jul;
    private BigDecimal aug;
    private BigDecimal sept;
    private BigDecimal oct;
    private BigDecimal nov;
    private BigDecimal dec;
    //资产或负债，0资产  1负债
    private Integer asset_or_debt;
    //创建时间
    private Timestamp create_date;

    private Boolean cnaModify;
    //条目名称
    private  String item_name;
    //条目表 定义条目表
    private Item item;

}
