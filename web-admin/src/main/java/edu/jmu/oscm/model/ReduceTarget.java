package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ReduceTarget {
    private int id;
    private BigInteger report_item_id;
    private String year;
    private Double year_percent;
    private BigDecimal year_value;
    private BigDecimal last_year_value;
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
    private Boolean asset_or_debt;

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

    public Double getYear_percent() {
        return year_percent;
    }

    public void setYear_percent(Double year_percent) {
        this.year_percent = year_percent;
    }

    public BigDecimal getYear_value() {
        return year_value;
    }

    public void setYear_value(BigDecimal year_value) {
        this.year_value = year_value;
    }

    public BigDecimal getLast_year_value() {
        return last_year_value;
    }

    public void setLast_year_value(BigDecimal last_year_value) {
        this.last_year_value = last_year_value;
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

    public Boolean getAsset_or_debt() {
        return asset_or_debt;
    }

    public void setAsset_or_debt(Boolean asset_or_debt) {
        this.asset_or_debt = asset_or_debt;
    }
}
