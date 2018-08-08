/**  
 * @Title: TeacherDao.java
 * @Package com.dao
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.dao;

import java.util.List;

import com.po.Teacher;

/**
 * ClassName: TeacherDao 
 * @Description: 教师Dao接口
 * @author Victor
 * @date 2017年6月29日
 */
public interface TeacherDao {
	//登录验证
	public Teacher loginValidate(String tId, String pwd, int rank);
	//添加教师
	public boolean addTeacher(Teacher obj);
	//更新教师信息
	public boolean updateTeacher(Teacher obj);
	//删除教师用户
	public boolean deleteTeacher(Teacher obj);
	//查询全部教师
	public List<Teacher> queryAllTeacher();
	//通过角色查询教师
	public List<Teacher> queryTeacherByRank(int rank);
	//通过教师编号查询
	public Teacher queryTeacherByTeacherid(int teacherId);
	//通过院系查询教师
	public List<Teacher> queryTeacherByDept(String dept);
	

}
