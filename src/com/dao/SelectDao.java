/**  
 * @Title: SelectDao.java
 * @Package com.dao
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.dao;

import java.util.List;

import com.po.Course;
import com.po.Select;
import com.po.Student;

/**
 * ClassName: SelectDao 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
public interface SelectDao {
	//新增选课记录
	public boolean addSelect(Select obj);
	//通过课程和学生查询选课
	public Select querySelectByCourseAndStudent(Course course, Student student);
	//删除选课记录
	public boolean deleteSelect(Select obj);
	//根据学生查询选课情况
	public List<Course> queryCourseByStudent(Student student);
	//根据课程查询学生情况
	public List<Student> queryStudentByCourse(Course course);
	//根据课程查询选课学生数量
	public long queryCountByCourse(Course course);
	//通过学生获取选课情况
	public List<Select> querySelectByStudent(Student student);
	//通过课程获取选课情况
	public List<Select> querySelectByCourse(Course course);
}
