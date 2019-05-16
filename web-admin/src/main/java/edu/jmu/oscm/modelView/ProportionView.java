package edu.jmu.oscm.modelView;

/**
 * @author zyx
 * @date 19-5-13 下午8:47
 * @email zhangyuxin2009@126.com
 */

public class ProportionView {
    private String itemName;
    private float value;
    private float prop;
    private float accumProp;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getProp() {
        return prop;
    }

    public void setProp(float prop) {
        this.prop = prop;
    }

    public float getAccumProp() {
        return accumProp;
    }

    public void setAccumProp(float accumProp) {
        this.accumProp = accumProp;
    }

    public ProportionView(String itemName, float value, float prop, float accumProp) {
        this.itemName = itemName;
        this.value = value;
        this.prop = prop;
        this.accumProp = accumProp;
    }

    @Override
    public String toString() {
        return "ProportionView{" +
                "itemName='" + itemName + '\'' +
                ", value=" + value +
                ", prop=" + prop +
                ", accumProp=" + accumProp +
                '}';
    }
}
