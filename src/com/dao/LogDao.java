/**  
 * @Title: LogDao.java
 * @Package com.dao
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.dao;

import java.util.List;

import com.po.Log;


/**
 * ClassName: LogDao 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
public interface LogDao {
	//新增系统开放时间
	public boolean addLog(Log obj);
	//更新记录
	public boolean updateLog(Log obj);
	//删除记录
	public boolean deleteLog(Log obj);
	//查询所有记录
	public List<Log> queryAllLog();
	//通过学期和备注查询
	public Log queryLogByYearsAndRemark();
	

}
