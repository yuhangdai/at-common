package com.aotain.nms.common.utils.push.dao;

import org.apache.ibatis.annotations.Param;

import com.aotain.nms.common.config.annotation.MyBatisDao;
import com.aotain.nms.common.model.push.PushMessage;

/**
 * 推送信息数据库操作接口
 *
 * @author Jason
 * @date 2017年8月7日 下午4:13:08
 */
@MyBatisDao
public interface PushMapper {
	
	public String getPushService();
	
	public String getPushServiceModule();
	
	/**
	 * 写入推送记录
	 * 
	 * @param msg
	 * @return
	 */
	public int insertPushMessage(PushMessage msg);

	/**
	 * 更新推送状态
	 * 
	 * @param pushId
	 * @param status 0-未推送，1-推送中，2-推送成功，3-推送失败
	 * @return
	 */
	public int updatePushMessageStatus(@Param("pushId")Long pushId, @Param("status")Integer status);

}
