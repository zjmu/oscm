package edu.jmu.oscm.model;
import lombok.Data;

import java.math.BigInteger;

import java.sql.Timestamp;
@Data
public class ImprovementPlan {

    //提升与改善计划表id
    private int id;

    //报告条目id
    private BigInteger item_id;

    //年度
    private String year;

    //月份
    private String month;

    //完成情况
    private int ok;

    //改善计划
    private String plan;

    //备注
    private String remark;

    //日期
    private Timestamp create_date;

    //外键对应的Item对象
    private  Item item;

}
