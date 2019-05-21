package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class BalanceTargetValue {

    private Integer id;
    private BigInteger reportItemId;
    private String year;
    private String month;
    private BigDecimal lastMonthBalance;
    private BigDecimal planMonthTargetValue;
    private BigDecimal planTotalReduceValue;
    private BigDecimal actualMonthTargetValue;
    private BigDecimal actualTotalReduceValue;
    private BigDecimal monthIncrementalValue;
    private BigDecimal totalIncrementalValue;
    private BigDecimal monthReward;
    private BigDecimal totalReward;
    private Timestamp createDate;
    private Boolean assetOrDebt;
    private List<ItemDept> itemDept;
    private List<ItemEmployee> itemEmployee;
    private ReportItemInstance reportItemInstance;

    public Boolean getAssetOrDebt() {
        return assetOrDebt;
    }

    public void setAssetOrDebt(Boolean assetOrDebt) {
        this.assetOrDebt = assetOrDebt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getReportItemId() {
        return reportItemId;
    }

    public void setReportItemId(BigInteger reportItemId) {
        this.reportItemId = reportItemId;
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

    public BigDecimal getLastMonthBalance() {
        return lastMonthBalance;
    }

    public void setLastMonthBalance(BigDecimal lastMonthBalance) {
        this.lastMonthBalance = lastMonthBalance;
    }

    public BigDecimal getPlanMonthTargetValue() {
        return planMonthTargetValue;
    }

    public void setPlanMonthTargetValue(BigDecimal planMonthTargetValue) {
        this.planMonthTargetValue = planMonthTargetValue;
    }

    public BigDecimal getPlanTotalReduceValue() {
        return planTotalReduceValue;
    }

    public void setPlanTotalReduceValue(BigDecimal planTotalReduceValue) {
        this.planTotalReduceValue = planTotalReduceValue;
    }

    public BigDecimal getActualMonthTargetValue() {
        return actualMonthTargetValue;
    }

    public void setActualMonthTargetValue(BigDecimal actualMonthTargetValue) {
        this.actualMonthTargetValue = actualMonthTargetValue;
    }

    public BigDecimal getActualTotalReduceValue() {
        return actualTotalReduceValue;
    }

    public void setActualTotalReduceValue(BigDecimal actualTotalReduceValue) {
        this.actualTotalReduceValue = actualTotalReduceValue;
    }

    public BigDecimal getMonthIncrementalValue() {
        return monthIncrementalValue;
    }

    public void setMonthIncrementalValue(BigDecimal monthIncrementalValue) {
        this.monthIncrementalValue = monthIncrementalValue;
    }

    public BigDecimal getTotalIncrementalValue() {
        return totalIncrementalValue;
    }

    public void setTotalIncrementalValue(BigDecimal totalIncrementalValue) {
        this.totalIncrementalValue = totalIncrementalValue;
    }

    public BigDecimal getMonthReward() {
        return monthReward;
    }

    public void setMonthReward(BigDecimal monthReward) {
        this.monthReward = monthReward;
    }

    public BigDecimal getTotalReward() {
        return totalReward;
    }

    public void setTotalReward(BigDecimal totalReward) {
        this.totalReward = totalReward;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public List<ItemDept> getItemDept() {
        return itemDept;
    }

    public void setItemDept(List<ItemDept> itemDept) {
        this.itemDept = itemDept;
    }

    public List<ItemEmployee> getItemEmployee() {
        return itemEmployee;
    }

    public void setItemEmployee(List<ItemEmployee> itemEmployee) {
        this.itemEmployee = itemEmployee;
    }

    public ReportItemInstance getReportItemInstance() {
        return reportItemInstance;
    }

    public void setReportItemInstance(ReportItemInstance reportItemInstance) {
        this.reportItemInstance = reportItemInstance;
    }
}
