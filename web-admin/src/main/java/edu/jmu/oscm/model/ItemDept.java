package edu.jmu.oscm.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;

@Data
public class ItemDept {

    private Integer id;
    private BigInteger reportItemId;
    private Integer isCharge;
    private String deptCode;
    private Department department;

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

    public Integer getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Integer isCharge) {
        this.isCharge = isCharge;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
