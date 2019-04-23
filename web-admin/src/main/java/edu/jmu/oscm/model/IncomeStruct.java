package edu.jmu.oscm.model;

import java.time.LocalDate;

public class IncomeStruct {
    private int incomeId;
    private String name;
    private String incomeCode;
    private int line;
    private int direction;
    private String monthForum;
    private String yearForum;

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncomeCode() {
        return incomeCode;
    }

    public void setIncomeCode(String incomeCode) {
        this.incomeCode = incomeCode;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getMonthForum() {
        return monthForum;
    }

    public void setMonthForum(String monthForum) {
        this.monthForum = monthForum;
    }

    public String getYearForum() {
        return yearForum;
    }

    public void setYearForum(String yearForum) {
        this.yearForum = yearForum;
    }
}
