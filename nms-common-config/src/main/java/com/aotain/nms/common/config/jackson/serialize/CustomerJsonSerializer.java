package com.aotain.nms.common.config.jackson.serialize;

import com.aotain.nms.common.config.annotation.JSON;
import com.aotain.nms.common.config.jackson.filter.JacksonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/04/23
 */
public class CustomerJsonSerializer {

    ObjectMapper objectMapper = new ObjectMapper();
    JacksonFilter jacksonFilter = new JacksonFilter();

    public void filter(Class<?> clazz, String[] include, String[] filter) {
        if (clazz == null)
            return;
        if (include.length > 0) {
            jacksonFilter.include(clazz, include);
        }
        if (filter.length > 0) {
            jacksonFilter.filter(clazz, filter);
        }
        objectMapper.addMixIn(clazz, jacksonFilter.getClass());
    }

    public String toJson(Object object) throws JsonProcessingException {
        objectMapper.setFilterProvider(jacksonFilter);
        return objectMapper.writeValueAsString(object);
    }

    public void filter(JSON json) {
        this.filter(json.type(), json.include(), json.filter());
    }

}
