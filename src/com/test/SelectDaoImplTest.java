/**  
 * @Title: SelectDaoImplTest.java
 * @Package com.test
 * @Description: TODO
 * @author Victor
 * @date 2017年7月3日
 */
package com.test;

import com.dao.SelectDao;
import com.po.Course;

/**
 * ClassName: SelectDaoImplTest 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月3日
 */
public class SelectDaoImplTest extends BaseCase {
	SelectDao selectDao;
	protected void setUp() throws Exception {
		selectDao = (SelectDao) super.getBean("selectDaoImpl");
		super.setUp();
	}
	public void testCount(){
		Course course = new Course();
		course.setcId(1);
		long temp = 0;
		temp = selectDao.queryCountByCourse(course);
		System.out.println(temp);
	}
	

}
