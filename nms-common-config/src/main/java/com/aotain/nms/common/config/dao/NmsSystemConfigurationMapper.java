package com.aotain.nms.common.config.dao;

import java.util.List;

import com.aotain.nms.common.config.annotation.MyBatisDao;
import com.aotain.nms.common.config.model.SystemConfiguration;

@MyBatisDao
public interface NmsSystemConfigurationMapper {

    List<SystemConfiguration> selectConfig();

}