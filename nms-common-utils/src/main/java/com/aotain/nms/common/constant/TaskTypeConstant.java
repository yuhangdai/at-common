package com.aotain.nms.common.constant;

public class TaskTypeConstant {

	//一键封堵任务类型
	public static final int TASK_TYPE_BLOCK = 1;
	
	//配置文件备份任务类型
	public static final int TASK_TYPE_CONFIG = 2;
	
	//一键封堵任务执行
	public static final int TASK_SUBTYPE_BLOCK_EXECUTING 		= 1000;
	
	//白名单判定
	public static final int TASK_SUBTYPE_BLOCK_WHITE	 		= 1001;
	
	//IP解析（DNS转译IP）
	public static final int TASK_SUBTYPE_BLOCK_IP_PARSING 		= 1002;
	
	//省内IP地址判定
	public static final int TASK_SUBTYPE_BLOCK_IP_PROVINCE		= 1003;

	//获取快照
	public static final int TASK_SUBTYPE_BLOCK_ATTACHMENT		= 1004;

	//封堵（一键封堵接口）
	public static final int TASK_SUBTYPE_BLOCK_INTERFACE		= 1005;

	//配置文件备份执行
	public static final int TASK_SUBTYPE_CONFIG_EXECUTING		= 2000;
	
	public static final String TASK_QUEUE = "NmsTaskQueue";

    public static final String TASK_CHANNEL = "NmsTaskChannel";
}
