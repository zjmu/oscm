package edu.jmu.oscm.model;
import lombok.Data;
import java.math.BigInteger;
import java.util.Date;
@Data
public class Item {
    private  BigInteger ID; //item表主键
    private  String item_code;//条目代码
    private  String item_name;//条目名称
    private  String calc_expr;//计算公式
    private  String calc_explain;//公式解释
    private  String state;//状态
    private  Date modify_date;//更新时间

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getCalc_expr() {
        return calc_expr;
    }

    public void setCalc_expr(String calc_expr) {
        this.calc_expr = calc_expr;
    }

    public String getCalc_explain() {
        return calc_explain;
    }

    public void setCalc_explain(String calc_explain) {
        this.calc_explain = calc_explain;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", item_code='" + item_code + '\'' +
                ", item_name='" + item_name + '\'' +
                ", calc_expr='" + calc_expr + '\'' +
                ", calc_explain='" + calc_explain + '\'' +
                ", state='" + state + '\'' +
                ", create_date=" + modify_date +
                '}';
    }
}
