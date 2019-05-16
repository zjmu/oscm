package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class IncentiveRatio {

    private Integer id;
    private String year;
    private BigDecimal interestRate;
    private BigDecimal incentiveRatio;
    private BigDecimal maxLimit;
    private Timestamp createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getIncentiveRatio() {
        return incentiveRatio;
    }

    public void setIncentiveRatio(BigDecimal incentiveRatio) {
        this.incentiveRatio = incentiveRatio;
    }

    public BigDecimal getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
