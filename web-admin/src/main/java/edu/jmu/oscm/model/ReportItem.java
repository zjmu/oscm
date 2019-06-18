package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

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
    private Item item;
    private Report report;
    private ReportItemInstance reportItemInstance;
    private ItemReduceTarget itemReduceTarget;

}
