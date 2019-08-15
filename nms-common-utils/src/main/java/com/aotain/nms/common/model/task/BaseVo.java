package com.aotain.nms.common.model.task;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 消息基类
 * @author Administrator
 *
 */
public class BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 	实体转JSON字符串
     * @return
     */
    public String objectToJson() {
        return JSON.toJSONString(this);
    }

    /**
     * 	字符串转消息实体
     * @param json
     * @param cls
     * @return
     */
    public static <T extends BaseVo> T parseFrom(String json, Class<T> cls) {
        return  JSON.parseObject(json,cls);
    }
}
