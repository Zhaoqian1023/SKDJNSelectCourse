/**  
 * @Title: MessageDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.MessageDao;
import com.po.Message;

/**
 * ClassName: MessageDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
@Repository("messageDaoImpl")
public class MessageDaoImpl extends BaseDaoImpl implements MessageDao {

	/* (非 Javadoc)
	* <p>Title: addMessage</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.MessageDao#addMessage(com.po.Message)
	*/
	@Override
	public boolean addMessage(Message obj) {
		return super.add(obj);
	}

	/* (非 Javadoc)
	* <p>Title: updateMessage</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.MessageDao#updateMessage(com.po.Message)
	*/
	@Override
	public boolean updateMessage(Message obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: deleteMessage</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.MessageDao#deleteMessage(com.po.Message)
	*/
	@Override
	public boolean deleteMessage(Message obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: queryMessageByAimShowAndFlag</p>
	* <p>Description: </p>
	* @param aimShow
	* @param flag
	* @return
	* @see com.dao.MessageDao#queryMessageByAimShowAndFlag(java.lang.String, int)
	*/
	@Override
	public List<Message> queryMessageByAimShowAndFlag(String aimShow, int flag) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryMessageByMid</p>
	* <p>Description: </p>
	* @param mid
	* @return
	* @see com.dao.MessageDao#queryMessageByMid(int)
	*/
	@Override
	public Message queryMessageByMid(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
