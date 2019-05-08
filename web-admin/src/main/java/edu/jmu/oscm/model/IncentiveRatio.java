package edu.jmu.oscm.model;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class IncentiveRatio {

    //部门奖励比例id
    private int id;

    //年份（每年一月，设置）
    private String year;

    //利率
    private BigDecimal interest_rate;

    //奖励比例
    private BigDecimal incentive_ratio;

    //大额资金限制
    private BigDecimal max_limit;

    //创建时间
    private Timestamp create_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }

    public BigDecimal getIncentive_ratio() {
        return incentive_ratio;
    }

    public void setIncentive_ratio(BigDecimal incentive_ratio) {
        this.incentive_ratio = incentive_ratio;
    }

    public BigDecimal getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(BigDecimal max_limit) {
        this.max_limit = max_limit;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }
}
