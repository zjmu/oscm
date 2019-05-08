package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author zyx
 * @date 19-5-7 下午8:00
 * @email zhangyuxin2009@126.com
 */

// 项目占比

@Data
public class Proportion {
    private int id;
    private BigInteger report_item_id;
    private String year;
    private String month;
    private String proportion;
    private String accumulate_proportion;
    private Boolean asset_or_debt;
    private String date;
}
