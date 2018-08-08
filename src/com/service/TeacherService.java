/**  
 * @Title: TeacherService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年7月3日
 */
package com.service;



import org.apache.poi.hssf.record.formula.functions.Int;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TeacherDao;
import com.po.Teacher;
import com.util.RandomUtil;

/**
 * ClassName: TeacherService 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月3日
 */
@Service("teacherService")
public class TeacherService {
	
	@Autowired
	@Qualifier("teacherDaoImpl")
	private TeacherDao teacherDao;
	/**
	 * 
	 * @Description: 登录验证
	 * @param @param teacherId 教师id
	 * @param @param password 密码
	 * @param @param rank 用户级别
	 * @return Teacher  返回教师对象
	 * @author Victor
	 * @date 2017年7月4日
	 */
	public Teacher loginValidate(String teacherId, String password, int rank){
		if(teacherId == null || password == null || "".equals(teacherId) || "".equals(password)){
			return null;
		}
		Teacher teacher = null;
		teacher = teacherDao.loginValidate(teacherId, password, rank);
		return teacher;
	}
	/**
	 * 
	 * @Description:  更新教师信息
	 * @param @param teacher 教师对象
	 * @return boolean  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	@Transactional
	public boolean updateTeacher(Teacher teacher){
		if(teacher == null){
			return false;
		}
		return teacherDao.updateTeacher(teacher);
	}
	/**
	 * 
	 * @Description: 添加教师
	 * @param @param teacher 教师对象
	 * @return boolean  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	@Transactional
	public boolean addTeacher(Teacher teacher){
		if(teacher == null){
			return false;
		}
		Teacher teacherTemp = teacherDao.queryTeacherByTeacherid(teacher.gettId());
		if(teacherTemp != null){
			return false;
		}
		teacher.setPassword("");
		return teacherDao.addTeacher(teacher);
	}
	/**
	 * 
	 * @Description: 查询教师
	 * @param @param teacherId 教师工号
	 * @return Teacher  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public Teacher getTeacher(String teacherId){
		int tId = 0;
		try {
			tId = Integer.parseInt(teacherId);
		} catch (NumberFormatException e) {
			return null;
		}
		Teacher teacher = null;
		teacher = teacherDao.queryTeacherByTeacherid(tId);
		return teacher;
	}
	/**
	 * 
	 * @Description:  生成八位密码，并更新密码
	 * @param @param teacherId 教师工号
	 * @return String  新密码
	 * @author Victor
	 * @date 2017年7月6日
	 */
	@Transactional
	public String modifyTeacherPwd(String teacherId){
		Teacher teacher = null;
		String pwd = "";
		int tId = 0;
		try {
			tId = Integer.parseInt(teacherId);
		} catch (NumberFormatException e) {
			return "fail";
		}
		teacher = teacherDao.queryTeacherByTeacherid(tId);
		if(teacher != null){
			pwd = RandomUtil.genEasyPswd(8);
			teacher.setPassword(pwd);
			if(teacherDao.updateTeacher(teacher)){
				return pwd;
			}
		}
		return "fail";
	}
	
	
	
	

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

}
