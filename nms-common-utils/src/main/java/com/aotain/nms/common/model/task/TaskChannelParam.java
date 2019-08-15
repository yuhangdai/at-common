package com.aotain.nms.common.model.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskChannelParam extends BaseVo {
	
	private static final long serialVersionUID = 8266249729507335794L;
	
	private Long commandid;
	private Integer commandtype;
	private String rule;
	private Integer ruletype;
	private String effect_time;
	private String expired_time;
	private String createtime;
}
