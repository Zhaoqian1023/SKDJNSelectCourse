/**  
 * @Title: StudentDao.java
 * @Package com.dao
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao;

import java.util.List;

import com.po.ClassName;
import com.po.Student;


/**
 * ClassName: StudentDao 
 * @Description: 学生dao接口
 * @author Victor
 * @date 2017年6月29日
 */
public interface StudentDao {
	
	//新增学生
	public boolean addStudent(Student student);
	//更新学生信息
	public boolean updateStudent(Student student);
	//删除学生
	public boolean deleteStudent(Student student);
	//通过学号和密码登录验证
	public Student loginValidate(String sId, String pwd);
	//查询所有学生
	public List<Student> queryAllStudent();
	//通过学号查询
	public Student queryStudentBySid(String sid);
	//通过班级查询
	public List<Student> queryStudentByClassName(ClassName classname);
	//通过学生状态查询
	public List<Student> queryStudentByState(String state);
	

}
