/**  
 * @Title: StudentDaoImplTest.java
 * @Package com.test
 * @Description: TODO
 * @author Victor
 * @date 2017年7月1日
 */
package com.test;

import java.util.List;

import com.dao.StudentDao;
import com.po.Student;

/**
 * ClassName: StudentDaoImplTest 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月1日
 */
public class StudentDaoImplTest extends BaseCase {
	StudentDao studentDao;
	protected void setUp() throws Exception {
		studentDao = (StudentDao) super.getBean("studentDaoImpl");
		super.setUp();
	}
	/*public void testQueryAllStudent(){
		List<Student> data = null;
		data = studentDao.queryAllStudent();
		for(Student stu:data){
			System.out.println(stu.getsName());
		}
	}*/
	public void testLoginValidate(){
		String sId = "201403204128";
		String pwd = "123";
		Student stu = studentDao.loginValidate(sId, pwd);
		System.out.println(stu.getsName());
	}
	/*public void testaddStudent(){
		String sId = "201403204128";
		Student stu = studentDao.queryStudentBySid(sId);
		System.out.println(stu.getsName());
		stu.setsName("赵迁");
		studentDao.updateStudent(stu);
	}*/

}
