/**  
 * @Title: CourseDao.java
 * @Package com.dao
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao;

import java.util.List;

import com.po.ClassName;
import com.po.Course;
import com.po.Teacher;

/**
 * ClassName: CourseDao 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
public interface CourseDao {
	//新增课程
	public boolean addCourse(Course obj);
	//更新课程信息
	public boolean updateCourse(Course obj);
	//删除课程
	public boolean deleteCourse(Course obj);
	//通过课程代码查询课程
	public Course queryCourseByCno(String cno);
	//通过id号查询课程
	public Course queryCourseByCid(int cid);
	//通过课程名和学期查询
	public Course queryCourseByNameAndYears(String name, String years);
	//通过学年学期查询
	public List<Course> queryCourseByYears(String years);
	//通过任课教师查询
	public List<Course> queryCourseByTeacher(Teacher teacher);
	//通过课程审核状态和查询
	public List<Course> queryCourseByState(int state);
	//通过学年和审核状态查询
	public List<Course> queryCourseByStateAndYears(String years, int state);
	//通过学分查询和学期
	public List<Course> queryCourseByCreditsAndYears(int credits, String years);
	//通过开放的班级和学期查询
	public List<Course> queryCourseByClassNameAndYears(ClassName classname, String years);
	//通过课程类别和学期查询
	public List<Course> queryCourseByCategoryAndYears(String category, String years);

}
