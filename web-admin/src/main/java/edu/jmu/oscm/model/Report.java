package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author zyx
 * @date 19-5-21 下午8:08
 * @email zhangyuxin2009@126.com
 */

@Data
public class Report {
    private BigInteger id;
    private String reportCode;
    private String reportName;
    private String state;
    private Date modifyTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Report(String reportCode, String reportName, String state) {
        this.reportCode = reportCode;
        this.reportName = reportName;
        this.state = state;
    }

    public Report(){

    }
}
