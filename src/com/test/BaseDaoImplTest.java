/**  
 * @Title: TeacherDaoTest.java
 * @Package com.test
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.test;

import com.dao.BaseDao;

/**
 * ClassName: BaseDaoImplTest 
 * @Description: 测试类
 * @author Victor
 * @date 2017年6月30日
 */
public class BaseDaoImplTest extends BaseCase {
	BaseDao dao ;
	protected void setUp() throws Exception {
		dao = (BaseDao) super.getBean("baseDaoImpl");
		super.setUp();
	}
	public void teatBaseDaoImpl(){
		
	}
}
