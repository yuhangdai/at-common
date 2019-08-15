package com.aotain.nms.common.utils;

import org.apache.commons.httpclient.NameValuePair;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/04/15
 */
public class NameValueObjectPair extends NameValuePair {

    private Object objectValue;

    public NameValueObjectPair(String name,String value,Object object){
        super(name,value);
        this.objectValue = object;
    }

    public Object getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(Object objectValue) {
        this.objectValue = objectValue;
    }
}
