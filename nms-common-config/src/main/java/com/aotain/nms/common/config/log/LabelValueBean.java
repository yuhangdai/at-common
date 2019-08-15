package com.aotain.nms.common.config.log;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/05/07
 */
public class LabelValueBean implements Serializable {
    private static final long serialVersionUID = -1384988812720447808L;
    private String itemLabel;
    private String itemValue;

    public LabelValueBean() {
    }

    public LabelValueBean(String itemLabel, String itemValue) {
        this.itemLabel = itemLabel;
        this.itemValue = itemValue;
    }

    public String getItemLabel() {
        return this.itemLabel;
    }

    public void setItemLabel(String label) {
        this.itemLabel = label;
    }

    public String getItemValue() {
        return this.itemValue;
    }

    public void setItemValue(String value) {
        this.itemValue = value;
    }

    public String toString() {
        return "LabelValueBean [" + this.itemLabel + ", " + this.itemValue + "]";
    }
}
