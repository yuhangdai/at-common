package com.aotain.nms.common.config;

import com.aotain.nms.common.config.redis.BaseRedisService;

/**
 * 获取配置信息相关类
 *
 * @author daiyh@aotain.com
 * @date 2017/11/15
 */
public class LocalConfig {

    private static LocalConfig localConfig = null;
    
    @SuppressWarnings("unchecked")
	private BaseRedisService<String, String, String> redisService = ContextUtil.getContext().getBean("baseRedisServiceImpl",BaseRedisService.class);

	private LocalConfig() { // 私有化构造器
	}

    public static LocalConfig getInstance() {
        if(localConfig==null){
            synchronized (LocalConfig.class) {
                if(localConfig==null){
                    localConfig =  new LocalConfig();
                }
            }
        }
        return localConfig;
    }

    /**
     * 根据KEY获得value
     * @param hashKey
     * @return
     */
	public String getHashValueByHashKey(String hashKey) {
		return redisService.getHash("nms_dict_system_config", hashKey);
	}

}
