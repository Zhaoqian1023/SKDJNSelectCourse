/**  
 * @Title: LogDaoImpl.java
 * @Package com.dao.impl
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.LogDao;
import com.po.Log;

/**
 * ClassName: LogDaoImpl 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
@Repository("logDaoImpl")
public class LogDaoImpl extends BaseDaoImpl implements LogDao {

	/* (非 Javadoc)
	* <p>Title: addLog</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.LogDao#addLog(com.po.Log)
	*/
	@Override
	public boolean addLog(Log obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: updateLog</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.LogDao#updateLog(com.po.Log)
	*/
	@Override
	public boolean updateLog(Log obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: deleteLog</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see com.dao.LogDao#deleteLog(com.po.Log)
	*/
	@Override
	public boolean deleteLog(Log obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: queryAllLog</p>
	* <p>Description: </p>
	* @return
	* @see com.dao.LogDao#queryAllLog()
	*/
	@Override
	public List<Log> queryAllLog() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc)
	* <p>Title: queryLogByYearsAndRemark</p>
	* <p>Description: </p>
	* @return
	* @see com.dao.LogDao#queryLogByYearsAndRemark()
	*/
	@Override
	public Log queryLogByYearsAndRemark() {
		// TODO Auto-generated method stub
		return null;
	}

}
