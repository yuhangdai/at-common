package com.aotain.nms.common.model.push;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Jason
 *
 */
public class SendData {

	private Long pushId;
	private Long subjectType;
	private String alarmTime;
	private String alarmHouse;
	private String commandType;
	private String content;
	private String alarmHost;// 告警主机
	private String alarmParam;// 告警参数
	private List<String> phoneReceiver; // 手机号
	private List<String> emailReceiver; // 邮件地址

	public Long getPushId() {
		return pushId;
	}

	public void setPushId(Long pushId) {
		this.pushId = pushId;
	}

	public Long getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Long subjectType) {
		this.subjectType = subjectType;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmHouse() {
		return alarmHouse;
	}

	public void setAlarmHouse(String alarmHouse) {
		this.alarmHouse = alarmHouse;
	}

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAlarmHost() {
		return alarmHost;
	}

	public void setAlarmHost(String alarmHost) {
		this.alarmHost = alarmHost;
	}

	public String getAlarmParam() {
		return alarmParam;
	}

	public void setAlarmParam(String alarmParam) {
		this.alarmParam = alarmParam;
	}

	public List<String> getPhoneReceiver() {
		return phoneReceiver;
	}

	public void setPhoneReceiver(List<String> phoneReceiver) {
		this.phoneReceiver = phoneReceiver;
	}

	public List<String> getEmailReceiver() {
		return emailReceiver;
	}

	public void setEmailReceiver(List<String> emailReceiver) {
		this.emailReceiver = emailReceiver;
	}

	@Override
	public String toString() {
		if (subjectType == 1) {
			return "告警时间：" + (StringUtils.isBlank(alarmTime) ? "" : alarmTime) + "\n" + 
					   "告警机房：" + (StringUtils.isBlank(alarmHouse) ? "" : alarmHouse) + "\n" + 
					   "指令类型：" + (StringUtils.isBlank(commandType) ? "" : commandType) + "\n" + 
					   "告警内容：" + (StringUtils.isBlank(content) ? "" : content);
		} else if (subjectType == 2) {
			if (StringUtils.isBlank(alarmHouse)) {
				return "告警时间：" + (StringUtils.isBlank(alarmTime) ? "" : alarmTime) + "\n" + 
						   "告警内容：" + (StringUtils.isBlank(content) ? "" : content);
			} else {
				return "告警时间：" + (StringUtils.isBlank(alarmTime) ? "" : alarmTime) + "\n" + 
						   "告警机房：" + (StringUtils.isBlank(alarmHouse) ? "" : alarmHouse) + "\n" + 
						   "告警内容：" + (StringUtils.isBlank(content) ? "" : content);
			}
		} else if (subjectType == 3) {
			return "告警时间：" + (StringUtils.isBlank(alarmTime) ? "" : alarmTime) + "\n" + 
					   "告警主机：" + (StringUtils.isBlank(alarmHost) ? "" : alarmHost) + "\n" + 
					   "告警内容：" + (StringUtils.isBlank(content) ? "" : content);
		}
		return "告警时间：" + (StringUtils.isBlank(alarmTime) ? "" : alarmTime) + "\n" + 
			   "告警机房：" + (StringUtils.isBlank(alarmHouse) ? "" : alarmHouse) + "\n" + 
			   "指令类型：" + (StringUtils.isBlank(commandType) ? "" : commandType) + "\n" + 
			   "告警内容：" + (StringUtils.isBlank(content) ? "" : content);
	}

}
