package edu.jmu.oscm.model;
import lombok.Data;

import java.math.BigInteger;

import java.sql.Timestamp;
@Data
public class ImprovementPlan {

    //提升与改善计划表id
    private int id;

    //报告条目id
    private BigInteger report_item_id;

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

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
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
        return "ImprovementPlan{" +
                "id=" + id +
                ", REPORT_ITEM_ID=" + report_item_id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", ok=" + ok +
                ", plan='" + plan + '\'' +
                ", remark='" + remark + '\'' +
                ", date='" + create_date + '\'' +
                '}';
    }
}
