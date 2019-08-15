package com.aotain.nms.common.utils.redis;

import com.aotain.nms.common.config.ContextUtil;
import com.aotain.nms.common.config.redis.BaseRedisService;

/**
 * 任务ID获取类
 *
 * @author bang
 * @date 2019/07/29
 */
public class TaskIdUtil {

    /**
     * redis实例
     */
    @SuppressWarnings("unchecked")
    private static BaseRedisService<String, Object, String> rediscluster = ContextUtil.getContext().getBean("baseRedisServiceImpl",BaseRedisService.class);

    /**
     * 任务ID在redis里面的key
     */
    private static String REDIS_TASKID_KEY = "nms_global_task_id";

    /**
     * 单例
     */
    private static TaskIdUtil instance = null;

    /**
     * 获得单例
     */
    public synchronized static TaskIdUtil getInstance(){
        if(instance == null){
            instance = new TaskIdUtil();
        }

        return instance;
    }

    /**
     * 获得TaskId
     * @return 任务ID
     */
    public Long getTaskId(){

        return rediscluster.incr(REDIS_TASKID_KEY);
    }

    /**
     * 获得当前TaskId
     * @return 任务ID
     */
    public Long getCurrentTaskId(){

        return Long.valueOf(rediscluster.getString(REDIS_TASKID_KEY));
    }

}
