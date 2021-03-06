package com.aotain.nms.common.model.push;

import java.util.Date;
import java.util.List;

/**
 * 推送信息
 *
 * @author Jason
 * @date 2017年8月7日 上午11:09:31
 */
public class PushMessage {
	private Long pushId;
	private Integer pushType; // 调用PushClient.pushAlarmMessage方法时，只需要提供sendData。1：邮件类型推送；2：短信类型推送；3：微信类型推送；
	private Long subjectType;//推送主题类型：1-管局指令，2-业务告警，3-IT资源告警
	private String sendData;  // JSON字符串，表示一个sendData对象,不同推送类型，数据结构不一样
	private Integer status;   // 状态: 0-提交，1-异常，2-成功
	private Date createTime;  // 创建时间
	private Date updateTime;  // 修改时间
	private List<String> phoneReceiver; // 手机号
	private List<String> emailReceiver; // 邮件地址

	public String getSendData() {
		return sendData;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setSendData(String sendData) {
		this.sendData = sendData;
	}

	public Long getPushId() {
		return pushId;
	}

	public void setPushId(Long pushId) {
		this.pushId = pushId;
	}

	public Integer getPushType() {
		return pushType;
	}

	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}
	
	public Long getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Long subjectType) {
		this.subjectType = subjectType;
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
		return "PushMessage [pushId=" + pushId + ", pushType=" + pushType + ", sendData=" + sendData + ", status=" + status + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
