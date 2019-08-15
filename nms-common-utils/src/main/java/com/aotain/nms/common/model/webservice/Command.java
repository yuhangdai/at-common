package com.aotain.nms.common.model.webservice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aotain.nms.common.tools.Tools;



public class Command {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1450429656489743691L;
	private Long commandId;//管局指令ID
	private String operateType;//指令操作类型，新增、删除
	private String effectTime;//指令生效时间
	private String expiredTime;//指令过期时间
	private String createTime;//创建时间
	private Integer type;//指令类型；1-解封|2-封堵
	
	private List<String> ipList;
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		Long longStr = 10L;
		map.put("1", longStr.toString());
		System.out.println(map.get("1"));
	}
	
	public CommandBean toXmlBean(Command dto) {
		CommandBean info = new CommandBean();
		info.setCommandId(dto.getCommandId().longValue());
		info.setType(dto.getType());
		info.setTimeStamp(Tools.getTimeStamp());
		List<CommandBean.IpList> ipList = new ArrayList<>();
		CommandBean.IpList ipInfo = null;
		if(dto.getIpList()!=null&&dto.getIpList().size()>0){
			for(String ip:dto.getIpList()){
				ipInfo = new CommandBean.IpList();
				ipInfo.setIp(ip);
				ipList.add(ipInfo);
			}
		}
		info.setIpList(ipList);
		CommandBean.Time time = new CommandBean.Time();
		time.setEffectTime(dto.getEffectTime());
		time.setExpiredTime(dto.getExpiredTime());
		info.setTime(time);
		
		return info;
	}
	

	public Long getCommandId() {
		return commandId;
	}

	public void setCommandId(Long commandId) {
		this.commandId = commandId;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}

	public String getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(String expiredTime) {
		this.expiredTime = expiredTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<String> getIpList() {
		return ipList;
	}

	public void setIpList(List<String> ipList) {
		this.ipList = ipList;
	}
	
	
	
}
