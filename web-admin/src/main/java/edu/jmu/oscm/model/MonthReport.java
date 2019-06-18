package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;

import java.math.BigInteger;

import java.sql.Timestamp;
import java.util.List;

@Data
public class MonthReport {

    //月度总结表id
    private int id;

    //报告条目id
    private BigInteger item_id;

    //年度
    private String year;

    //月份
    private String month;

    //目标值
    private BigDecimal target;

    //末余额
    private  BigDecimal value;

    //偏差值
    private  BigDecimal difference;

    //本期主要管控措施
    private  String measure;

    //经验
    private  String experience;

    //不足
    private  String deficiency;

    //考核人评价
    private  String evaluate;

    //备注
    private  String remark;

    //创建日期
    private  Timestamp create_date;

    private  int index;

    //外键对应的Item对象
    private  Item item;
    private  String item_name;
    private List<Employee> responsibleEmployee;
    private List<Employee> collaborativeEmployee;
    private List<Department> responsibleDepartments;
    private List<Department> collaborativeDepartments;
}
