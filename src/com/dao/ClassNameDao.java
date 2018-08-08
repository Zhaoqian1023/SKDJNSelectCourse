/**  
 * @Title: ClassNameDao.java
 * @Package com.dao
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao;

import java.util.List;

import com.po.ClassName;

/**
 * ClassName: ClassNameDao 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
public interface ClassNameDao {
	//添加班级
	public boolean addClassName(ClassName obj);
	//更新班级
	public boolean updateClassName(ClassName obj);
	//删除班级
	public boolean deleteClassName(ClassName obj);
	//查询所有班级
	public List<ClassName> queryAllClassName();
	//通过班级模糊查询,如计算机科学与技术2014
	public List<ClassName> queryClassNameByName(String name);
	//通过班号查询班级信息
	public ClassName queryClassNameByCid(int cid);
	
}
