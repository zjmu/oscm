package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;

/**
 * @author zyx
 * @date 19-5-7 下午8:00
 * @email zhangyuxin2009@126.com
 */

// 项目占比

@Data
public class Proportion {
    private int id;
    private BigInteger report_item_id;
    private String year;
    private String month;
    private String proportion;
    private String accumulate_proportion;
    private Boolean asset_or_debt;
    private String create_date;

    private ReportItemInstance reportItemInstance;

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

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getAccumulate_proportion() {
        return accumulate_proportion;
    }

    public void setAccumulate_proportion(String accumulate_proportion) {
        this.accumulate_proportion = accumulate_proportion;
    }

    public Boolean getAsset_or_debt() {
        return asset_or_debt;
    }

    public void setAsset_or_debt(Boolean asset_or_debt) {
        this.asset_or_debt = asset_or_debt;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public ReportItemInstance getReportItemInstance() {
        return reportItemInstance;
    }

    public void setReportItemInstance(ReportItemInstance reportItemInstance) {
        this.reportItemInstance = reportItemInstance;
    }
}
