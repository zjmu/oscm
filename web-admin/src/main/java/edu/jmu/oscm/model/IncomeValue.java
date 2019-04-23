package edu.jmu.oscm.model;

import java.time.LocalDate;

public class IncomeValue {
    private int id;
    private int incomeId;
    private String year;
    private String month;
    private float monthAmount;
    private float yearAmount;
    private LocalDate createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
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

    public float getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(float monthAmount) {
        this.monthAmount = monthAmount;
    }

    public float getYearAmount() {
        return yearAmount;
    }

    public void setYearAmount(float yearAmount) {
        this.yearAmount = yearAmount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
