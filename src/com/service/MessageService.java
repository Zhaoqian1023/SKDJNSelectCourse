/**  
 * @Title: MessageService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年7月5日
 */
package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MessageDao;
import com.po.Message;
import com.util.DateUtil;

/**
 * ClassName: MessageService 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月5日
 */
@Service("messageService")
public class MessageService {
	@Autowired
	@Qualifier("messageDaoImpl")
	private MessageDao messageDao;
	
	/**
	 * 
	 * @Description: 新增消息
	 * @param @param message
	 * @return boolean  
	 * @author Victor
	 * @date 2017年7月5日
	 */
	@Transactional
	public boolean addMessage(Message message){
		if(message == null){
			return false;
		}
		String time = DateUtil.getDate();
		message.setTimes(time);
		message.setFlag(0);
		return messageDao.addMessage(message);
	}

	
	
	
	
	
	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	

}
