package edu.jmu.oscm.model;

import java.time.LocalDate;

public class Credence {

    private int credenceId;
    private String credenceNo;
    private String substract;
    private String departmentId;
    private String subjectId;
    private String subjectName;
    private float borrowMoney;
    private float lendMoney;
    private int employeeId;
    private String employeeName;
    private LocalDate happenData;

    public int getCredenceId() {
        return credenceId;
    }

    public void setCredenceId(int credenceId) {
        this.credenceId = credenceId;
    }

    public String getCredenceNo() {
        return credenceNo;
    }

    public void setCredenceNo(String credenceNo) {
        this.credenceNo = credenceNo;
    }

    public String getSubstract() {
        return substract;
    }

    public void setSubstract(String substract) {
        this.substract = substract;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public float getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(float borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public float getLendMoney() {
        return lendMoney;
    }

    public void setLendMoney(float lendMoney) {
        this.lendMoney = lendMoney;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getHappenData() {
        return happenData;
    }

    public void setHappenData(LocalDate happenData) {
        this.happenData = happenData;
    }
}
