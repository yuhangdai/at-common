package com.aotain.nms.common.model.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskQueue extends BaseVo {

	private static final long serialVersionUID = 1354364210461784724L;

	private Long taskid;
	private Long toptaskid;
	private Integer tasktype;
	private Integer tasksubtype;
	private Long commandid;
	private Integer commandtype;
	private String rule;
	private Integer ruletype;
	private String effect_time;
	private String expired_time;
	private String createtime;
	
}
