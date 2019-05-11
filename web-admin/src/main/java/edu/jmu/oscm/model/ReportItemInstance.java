package edu.jmu.oscm.model;

import com.fasterxml.jackson.databind.node.BigIntegerNode;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author zyx
 * @date 19-5-11 下午4:09
 * @email zhangyuxin2009@126.com
 */

// 对应report_item_instance

@Data
public class ReportItemInstance {
    private BigInteger ID;
    private BigInteger REPORT_ITEM_ID;
    private String REPORT_CODE;
    private String REPORT_NAME;
    private String OBJECT_TYPE;
    private String OBJECT_ID;
    private String ITEM_CODE;
    private String ITEM_NAME;
    private int ORDER_NUM;
    private String YEAR;
    private String MONTH;
    private String BEGIN_VALUE;
    private String VALUE;
    private String END_VALUE;
    private Date MODIFY_TIME;

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public BigInteger getREPORT_ITEM_ID() {
        return REPORT_ITEM_ID;
    }

    public void setREPORT_ITEM_ID(BigInteger REPORT_ITEM_ID) {
        this.REPORT_ITEM_ID = REPORT_ITEM_ID;
    }

    public String getREPORT_CODE() {
        return REPORT_CODE;
    }

    public void setREPORT_CODE(String REPORT_CODE) {
        this.REPORT_CODE = REPORT_CODE;
    }

    public String getREPORT_NAME() {
        return REPORT_NAME;
    }

    public void setREPORT_NAME(String REPORT_NAME) {
        this.REPORT_NAME = REPORT_NAME;
    }

    public String getOBJECT_TYPE() {
        return OBJECT_TYPE;
    }

    public void setOBJECT_TYPE(String OBJECT_TYPE) {
        this.OBJECT_TYPE = OBJECT_TYPE;
    }

    public String getOBJECT_ID() {
        return OBJECT_ID;
    }

    public void setOBJECT_ID(String OBJECT_ID) {
        this.OBJECT_ID = OBJECT_ID;
    }

    public String getITEM_CODE() {
        return ITEM_CODE;
    }

    public void setITEM_CODE(String ITEM_CODE) {
        this.ITEM_CODE = ITEM_CODE;
    }

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public int getORDER_NUM() {
        return ORDER_NUM;
    }

    public void setORDER_NUM(int ORDER_NUM) {
        this.ORDER_NUM = ORDER_NUM;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getMONTH() {
        return MONTH;
    }

    public void setMONTH(String MONTH) {
        this.MONTH = MONTH;
    }

    public String getBEGIN_VALUE() {
        return BEGIN_VALUE;
    }

    public void setBEGIN_VALUE(String BEGIN_VALUE) {
        this.BEGIN_VALUE = BEGIN_VALUE;
    }

    public String getVALUE() {
        return VALUE;
    }

    public void setVALUE(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getEND_VALUE() {
        return END_VALUE;
    }

    public void setEND_VALUE(String END_VALUE) {
        this.END_VALUE = END_VALUE;
    }

    public Date getMODIFY_TIME() {
        return MODIFY_TIME;
    }

    public void setMODIFY_TIME(Date MODIFY_TIME) {
        this.MODIFY_TIME = MODIFY_TIME;
    }
}
