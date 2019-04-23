package edu.jmu.oscm.model;

import java.sql.Timestamp;

/*
  资产负债项目表POJO
  @author zyx
 * @date 19-4-21 下午7:00
 * @email zhangyuxin2009@126.com
 */

public class BalanceStruct {
    // 项目ID
    private int item_id;

    // 项目名称
    private String name;

    // 项目编码
    private String item_code;

    // 行号
    private int line;

    // 类型(0项目  1统计项)
    private int type_id;

    // 分类名称
    private String category;

    // 期初公式
    private String begin_forum;

    // 期末公式
    private String end_forum;

    // 生成日期
    private Timestamp create_date;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBegin_forum() {
        return begin_forum;
    }

    public void setBegin_forum(String begin_forum) {
        this.begin_forum = begin_forum;
    }

    public String getEnd_forum() {
        return end_forum;
    }

    public void setEnd_forum(String end_forum) {
        this.end_forum = end_forum;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "BalanceStruct{" +
                "item_id=" + item_id +
                ", name='" + name + '\'' +
                ", item_code='" + item_code + '\'' +
                ", line=" + line +
                ", type_id=" + type_id +
                ", category='" + category + '\'' +
                ", begin_forum='" + begin_forum + '\'' +
                ", end_forum='" + end_forum + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
