package com.dao;

import java.util.List;

/**
 * ClassName: BaseDao
 * @Description: 底层DAO接口
 * @author Victor
 * @date 2017年6月29日
 */
public interface BaseDao {
	
	//保存对象
	public boolean add(Object obj);
	//自动机制（保存或更新）
	public boolean addOrUpdate(Object obj);
	//删除对象
	public boolean delete(Object obj);
	//更新对象
	public boolean update(Object obj);
	//通过表记录id获取对象
	public Object query(Class po, java.io.Serializable id);
	//通过SQL查询获取结果集返回制定类对象集合
	public List queryListBySQL(String sql, Class obj);
	//通过HQL语句查询获取结果集
	public List queryListByHQL(String hql);
	//通过SQL语句查询
	public List queryListBySQL(String sql);
	
	

}
