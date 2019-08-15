package com.aotain.nms.common.model.task;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskQueues extends BaseVo {
	
	private static final long serialVersionUID = -52408351556781105L;

	private List<TaskQueue> commandinfo;
	
	private List<TaskQueue> whiteinfo;
	
	private List<TaskQueue> ipinfo;
	
	private List<TaskQueue> iplist;
	
}
