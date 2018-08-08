/**  
 * @Title: MessageDao.java
 * @Package com.dao
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.dao;

import java.util.List;

import com.po.Message;

/**
 * ClassName: MessageDao 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
public interface MessageDao {
	//新增公告消息
	public boolean addMessage(Message obj);
	//更新公告信息
	public boolean updateMessage(Message obj);
	//删除公告
	public boolean deleteMessage(Message obj);
	//通过显示对象和消息状态查询公告（针对单个学生、全部用户）
	public List<Message> queryMessageByAimShowAndFlag(String aimShow, int flag);
	//通过Id查询
	public Message queryMessageByMid(int mid);
	
}
