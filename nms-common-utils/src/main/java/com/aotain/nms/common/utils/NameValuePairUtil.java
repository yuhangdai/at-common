package com.aotain.nms.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/04/15
 */
public class NameValuePairUtil {
    private static final Logger logger = LoggerFactory.getLogger(NameValuePairUtil.class);

    public static NameValueObjectPair[] getBeanNameValuePair(Object bean) {
        // 获取实体类所有属性
        Field[] fields = bean.getClass().getDeclaredFields();
        NameValueObjectPair[] nameValuePairs = new NameValueObjectPair[fields.length];
        // 依次获取每一个属性 创建NameValuePair
        if (fields==null||fields.length==0){
            return null;
        }
        for (int i=0;i<fields.length;i++){
            final Field field = fields[i];
            field.setAccessible(true);
            JSONField jsonField = field.getAnnotation(JSONField.class);
            try{
                Object value = field.get(bean);
                nameValuePairs[i] = new NameValueObjectPair(jsonField==null ? field.getName() : jsonField.name(), JSON.toJSONString(value),value);
            } catch (IllegalAccessException e){
                logger.error("getBeanNameValuePair fail...",e);
            }
        }
        return nameValuePairs;
    }
    
    /**
     * 
     * 获取子类和父类的属性字段
     */
    public static NameValueObjectPair[] getBeanNameValuePair2(Object bean) {
        // 获取实体类所有属性
        Class tempClass = bean.getClass();
        List<Field> fieldList = new ArrayList<>() ;
        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(tempClass .getDeclaredFields()));
            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
       }
        NameValueObjectPair[] nameValuePairs = new NameValueObjectPair[fieldList.size()];
        // 依次获取每一个属性 创建NameValuePair
        if (fieldList==null||fieldList.size()==0){
            return null;
        }
        for (int i=0;i<fieldList.size();i++){
            final Field field = fieldList.get(i);
            field.setAccessible(true);
            JSONField jsonField = field.getAnnotation(JSONField.class);
            try{
                Object value = field.get(bean);
                nameValuePairs[i] = new NameValueObjectPair(jsonField==null ? field.getName() : jsonField.name(), JSON.toJSONString(value),value);
            } catch (IllegalAccessException e){
                logger.error("getBeanNameValuePair fail...",e);
            }
        }
        return nameValuePairs;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString("aaa"));
    }
}
