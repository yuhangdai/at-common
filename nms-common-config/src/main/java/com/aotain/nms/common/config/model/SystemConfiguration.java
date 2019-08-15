package com.aotain.nms.common.config.model;

import lombok.Data;

@Data
public class SystemConfiguration {

    private Integer configId;

    private String configKey;

    private String configValue;

    private String configName;

    private String configDesc;

    private Integer inputType;

    private String inputItems;

    private Integer modelType;
    
    private String createTime;

    private String modifyTime;

    private String createUser;

    private String modifyUser;

}