package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;

import java.math.BigInteger;

import java.sql.Timestamp;

@Data
public class MonthReport {

    //月度总结表id
    private int id;

    //报告条目id
    private BigInteger report_item_id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getReport_item_id() {
        return report_item_id;
    }

    public void setReport_item_id(BigInteger report_item_id) {
        this.report_item_id = report_item_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    public void setDifference(BigDecimal difference) {
        this.difference = difference;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDeficiency() {
        return deficiency;
    }

    public void setDeficiency(String deficiency) {
        this.deficiency = deficiency;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "MonthReport{" +
                "id=" + id +
                ", report_item_id=" + report_item_id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", target=" + target +
                ", value=" + value +
                ", difference=" + difference +
                ", measure='" + measure + '\'' +
                ", experience='" + experience + '\'' +
                ", deficiency='" + deficiency + '\'' +
                ", evaluate='" + evaluate + '\'' +
                ", remark='" + remark + '\'' +
                ", create_date='" + create_date + '\'' +
                '}';
    }
}
