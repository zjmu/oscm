package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ItemReduceTarget {

    private int id;
    private BigInteger itemId;
    private String year;
    private String DeptCode;
    private String DeptName;
    private Double yearPercent;
    private BigDecimal yearValue;
    private BigDecimal lastYearValue;
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
    private Boolean assetOrDebt;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getYearPercent() {
        return yearPercent;
    }

    public void setYearPercent(Double yearPercent) {
        this.yearPercent = yearPercent;
    }

    public BigDecimal getYearValue() {
        return yearValue;
    }

    public void setYearValue(BigDecimal yearValue) {
        this.yearValue = yearValue;
    }

    public BigDecimal getLastYearValue() {
        return lastYearValue;
    }

    public void setLastYearValue(BigDecimal lastYearValue) {
        this.lastYearValue = lastYearValue;
    }

    public BigDecimal getJan() {
        return jan;
    }

    public void setJan(BigDecimal jan) {
        this.jan = jan;
    }

    public BigDecimal getFeb() {
        return feb;
    }

    public void setFeb(BigDecimal feb) {
        this.feb = feb;
    }

    public BigDecimal getMar() {
        return mar;
    }

    public void setMar(BigDecimal mar) {
        this.mar = mar;
    }

    public BigDecimal getApr() {
        return apr;
    }

    public void setApr(BigDecimal apr) {
        this.apr = apr;
    }

    public BigDecimal getMay() {
        return may;
    }

    public void setMay(BigDecimal may) {
        this.may = may;
    }

    public BigDecimal getJun() {
        return jun;
    }

    public void setJun(BigDecimal jun) {
        this.jun = jun;
    }

    public BigDecimal getJul() {
        return jul;
    }

    public void setJul(BigDecimal jul) {
        this.jul = jul;
    }

    public BigDecimal getAug() {
        return aug;
    }

    public void setAug(BigDecimal aug) {
        this.aug = aug;
    }

    public BigDecimal getSept() {
        return sept;
    }

    public void setSept(BigDecimal sept) {
        this.sept = sept;
    }

    public BigDecimal getOct() {
        return oct;
    }

    public void setOct(BigDecimal oct) {
        this.oct = oct;
    }

    public BigDecimal getNov() {
        return nov;
    }

    public void setNov(BigDecimal nov) {
        this.nov = nov;
    }

    public BigDecimal getDec() {
        return dec;
    }

    public void setDec(BigDecimal dec) {
        this.dec = dec;
    }

    public Boolean getAssetOrDebt() {
        return assetOrDebt;
    }

    public void setAssetOrDebt(Boolean assetOrDebt) {
        this.assetOrDebt = assetOrDebt;
    }
}
