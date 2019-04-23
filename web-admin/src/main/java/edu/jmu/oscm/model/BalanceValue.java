package edu.jmu.oscm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
  资产负债计算值表POJO
  @author zyx
 * @date 19-4-21 下午7:20
 * @email zhangyuxin2009@126.com
 */

@Data
public class BalanceValue {
    // 项目ID
    private int id;

    // 项目编码
    private int item_id;

    // 年
    private String year;

    // 月
    private String month;

    // 期初
    private BigDecimal begin_balance;

    // 期末
    private BigDecimal end_balance;

    // 生成日期
    private Timestamp create_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getBegin_balance() {
        return begin_balance;
    }

    public void setBegin_balance(BigDecimal begin_balance) {
        this.begin_balance = begin_balance;
    }

    public BigDecimal getEnd_balance() {
        return end_balance;
    }

    public void setEnd_balance(BigDecimal end_balance) {
        this.end_balance = end_balance;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "BalanceValue{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", begin_balance=" + begin_balance +
                ", end_balance=" + end_balance +
                ", create_date=" + create_date +
                '}';
    }
}
