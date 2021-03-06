package com.aotain.nms.common.utils.push;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aotain.nms.common.tools.FileUtils;

/**
 * 消息推送配置文件管理
 *
 * @author Jason
 * @date 2017年8月7日 下午2:52:06
 */
public class PushConfigUtils {
	private static Logger logger = LoggerFactory.getLogger(PushConfigUtils.class);
	private static Map<String, String> data = new HashMap<String, String>();

	private static final String PROVINCE_SHORT = "province.short"; // 省份简称
	private static final String PUSH_SUBJECT = "push.subject"; // 省份简称

	private static final String PUSH_URL = "push.url";

	static {
		try {
			Properties pro = FileUtils.loadPropertiesFromConfig("config","push.properties","UTF-8");
			if (pro == null) {
				throw new RuntimeException("推送配置文件push.properties加载失败");
			} else {
				for (Entry<Object, Object> obj : pro.entrySet()) {
					data.put((String) obj.getKey(), (String) obj.getValue());
				}
				obtainData();
			}
		} catch (Exception e) {
			logger.warn("安全认证工具参数初始化异常，部分参数将采用默认配置", e);
		}
	}

	/**
	 * 加载推送收信地址配置(从redis中读取)
	 * 
	 * @throws SQLException
	 */
	private static void obtainData() {
		//data.put(PUSH_RECEIVER_EMAILS, LocalConfig.getInstance().getHashValueByHashKey(PUSH_RECEIVER_EMAILS));
		//data.put(PUSH_RECEIVER_PHONES, LocalConfig.getInstance().getHashValueByHashKey(PUSH_RECEIVER_PHONES));
	}

	/**
	 * 获取值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return data.get(key);
	}

	/**
	 * 获取省份简称
	 * 
	 * @return
	 */
	public static String getProviceShort() {
		return data.get(PROVINCE_SHORT);
	}

	/**
	 * 推送主题
	 * 
	 * @return
	 */
	public static String getPushSubject() {
		String subject = data.get(PUSH_SUBJECT);
		if(StringUtils.isBlank(subject)){
			return "NMS告警信息";
		}
		return subject;
	}

	/**
	 * 获取指令推送微信地址
	 * 
	 * @return
	 */
	public static List<String> getPushCmdDstWechat() {
		String key = "province." + getProviceShort() + ".cmd.wechat.departmentId";
		String values = data.get(key);
		String[] departmentIds = StringUtils.split(values, ",");
		List<String> rs = new ArrayList<String>();
		if (departmentIds == null) {
			return rs;
		}
		for (String departmentId : departmentIds) {
			try {
				Integer.parseInt(departmentId);
				rs.add(departmentId);
			} catch (NumberFormatException e) {
				logger.error("不合法的微信推送目标地址(部门ID)：" + departmentId, e);
			}
		}
		return rs;
	}

	/**
	 * 获取指令邮件推送地址
	 * 
	 * @return
	 */
//	public static List<String> getPushCmdDstEmail() {
//		obtainData();
//		// 取消配置文件中加载,改从数据库中加载
//		// String key = "province." + getProviceShort() + ".cmd.email";
//		String key = PUSH_RECEIVER_EMAILS;
//		String values = data.get(key);
//		String[] emails = StringUtils.split(values, ",");
//		List<String> rs = new ArrayList<String>();
//		if (emails == null) {
//			return rs;
//		}
//		for (String email : emails) {
//			if (!email.matches(EMAIL_REGEX)) {
//				logger.error("不合法的邮件推送目标地址：" + email);
//			} else {
//				rs.add(email);
//			}
//		}
//		return rs;
//	}

	/**
	 * 邮件发送服务器账号
	 * 
	 * @return
	 */
//	public static String getPushMailServer() {
//		obtainData();
//		// String key = "province." + getProviceShort() + ".cmd.phone";
//		// 取消配置文件中加载,改从数据库中加载
//		String key = PUSH_RECEIVER_PHONES;
//		String value = data.get(key);
//		if (!value.matches(EMAIL_REGEX)) {
//			logger.error("不合法的邮件推送服务器地址：" + value);
//			return null;
//		}
//		return value;
//	}

	/**
	 * 获取指令邮件推送地址
	 * 
	 * @return
	 */
//	public static List<String> getPushCmdDstPhone() {
//		/*
//		 * String key = "province." + getProviceShort() + ".cmd.phone"; String
//		 * values = data.get(key);
//		 */
//		String values = data.get("receiver_phones");
//		String[] phones = StringUtils.split(values, ",");
//		List<String> rs = new ArrayList<String>();
//		if (phones == null) {
//			return rs;
//		}
//		for (String phone : phones) {
//			if (!phone.matches(PHONE_REGEX)) {
//				logger.error("不合法的短信推送目标地址：" + phone);
//			} else {
//				rs.add(phone);
//			}
//		}
//		return rs;
//	}

	public static Map<String, String> getProperties() {
		return data;
	}

	public static String getPushUrl() {
		String key = PUSH_URL;
		return data.get(key);
	}
	
	public static void main(String[] args) {
		System.out.println(PushConfigUtils.getPushSubject());
	}

}
