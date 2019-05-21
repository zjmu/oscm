package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author zyx
 * @date 19-5-21 下午7:58
 * @email zhangyuxin2009@126.com
 */

@Data
public class ReportItem {
    private BigInteger id;
    private BigInteger reportId;
    private BigInteger itemId;
    private int orderNum;
    private String state;
    private Date modifyTime;



    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getReportId() {
        return reportId;
    }

    public void setReportId(BigInteger reportId) {
        this.reportId = reportId;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
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
}
