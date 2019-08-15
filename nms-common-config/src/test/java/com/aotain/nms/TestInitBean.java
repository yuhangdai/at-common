package com.aotain.nms;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aotain.nms.common.config.LocalConfig;
import com.aotain.nms.common.config.dao.NmsSystemConfigurationMapper;
import com.aotain.nms.common.config.model.SystemConfiguration;
import com.aotain.nms.common.config.redis.BaseRedisService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-base.xml" })
public class TestInitBean {

	private static final String NMS_SYSTEM_CONFIGURATION_CONFIG = "nms_dict_system_config";
	
	@Autowired
	private NmsSystemConfigurationMapper nmsSystemConfigurationMapper;

	@Autowired
	private BaseRedisService<String, String, String> baseRedisService;

	@Test
	@Rollback(false)
	public void testRedisList() {
		baseRedisService.rightPush("NmsTaskQueue","1");
		baseRedisService.rightPush("NmsTaskQueue","2");
		baseRedisService.rightPush("NmsTaskQueue","3");
		System.out.println("===="+baseRedisService.listSize("NmsTaskQueue"));
		List<String> result = baseRedisService.getAllListData("NmsTaskQueue");
		System.out.println("===="+baseRedisService.listSize("NmsTaskQueue"));
	}


	@Test
	@Rollback(false)
	public void testInitConfig() {
		initConfiguration();
	}
	
	@Test
	@Rollback(false)
	public void testGet() {
		System.out.println(LocalConfig.getInstance().getHashValueByHashKey("push_file_path"));
	}
	
	private void initConfiguration() {
		List<SystemConfiguration> systemConfigurationList = nmsSystemConfigurationMapper.selectConfig();
		if (systemConfigurationList.isEmpty()) {
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
	}
	
}
