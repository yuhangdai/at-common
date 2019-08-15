package com.aotain.nms.common.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aotain.nms.common.config.dao.NmsSystemConfigurationMapper;
import com.aotain.nms.common.config.model.SystemConfiguration;
import com.aotain.nms.common.config.redis.BaseRedisService;

/**
 * 将数据库中的配置信息保存到redis中
 * @author Jason
 *
 */
@Repository
public class ConfigInitialingBean {

	public static final Logger configLog = Logger.getLogger(ConfigInitialingBean.class);

	@Autowired
	private NmsSystemConfigurationMapper nmsSystemConfigurationMapper;

	@Autowired
	private BaseRedisService<String, String, String> baseRedisService;

	private static final String NMS_SYSTEM_CONFIGURATION_CONFIG = "nms_dict_system_config";

	// 初始化时将数据库配置信息写入redis缓存中
	@PostConstruct
	public void initConfig() {
		configLog.info("Initialize the system configuration start....");
		try {
			initConfiguration();
		} catch (Exception e) {
			configLog.info("Initialize the system configuration start exception ....",e);
		}
	}

	private void initConfiguration() {
		configLog.info("Initialize the nms_dict_system_config configuration start....");
		List<SystemConfiguration> systemConfigurationList = nmsSystemConfigurationMapper.selectConfig();
		if (systemConfigurationList.isEmpty()) {
			configLog.info("There is no data in the table [nms_dict_system_config]!");
			return;
		}
		// 将查询的配置信息保存到redis中
		for (SystemConfiguration systemConfiguration : systemConfigurationList) {
			String key, value = null;
			String type = systemConfiguration.getConfigKey();
			if (type != null) {
				key = type;
				value = systemConfiguration.getConfigValue();
			} else {
				key = systemConfiguration.getConfigKey();
				value = systemConfiguration.getConfigValue() == null ? "undefined" : systemConfiguration.getConfigValue();
			}
			baseRedisService.putHash(NMS_SYSTEM_CONFIGURATION_CONFIG, key, value);
		}
		configLog.info("Initialize the nms_dict_system_config configuration end....");
	}

}
