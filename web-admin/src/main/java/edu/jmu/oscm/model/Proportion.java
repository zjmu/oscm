package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zyx
 * @date 19-5-7 下午8:00
 * @email zhangyuxin2009@126.com
 */

// 项目占比

@Data
public class Proportion {
    private int id;
    private BigInteger itemId;
    private String itemCode;
    private String itemName;
    private String year;
    private String month;
    private String proportion;
    private String accumulateProportion;
    private Boolean assetOrDebt;
    private String createDate;
    private ReportItem reportItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getAccumulateProportion() {
        return accumulateProportion;
    }

    public void setAccumulateProportion(String accumulateProportion) {
        this.accumulateProportion = accumulateProportion;
    }

    public Boolean getAssetOrDebt() {
        return assetOrDebt;
    }

    public void setAssetOrDebt(Boolean assetOrDebt) {
        this.assetOrDebt = assetOrDebt;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public ReportItem getReportItem() {
        return reportItem;
    }

    public void setReportItem(ReportItem reportItem) {
        this.reportItem = reportItem;
    }
}
