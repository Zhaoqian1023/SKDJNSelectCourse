/**  
 * @Title: StudentService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年7月1日
 */
package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ClassNameDao;
import com.dao.SelectDao;
import com.dao.StudentDao;
import com.po.ClassName;
import com.po.Course;
import com.po.Select;
import com.po.Student;
import com.po.TeachingPlan;
import com.vo.Unqualified;

/**
 * ClassName: StudentService 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月1日
 */
@Service("studentService")
public class StudentService {
	
	@Autowired
	@Qualifier("studentDaoImpl")
	private StudentDao studentDao;
	@Autowired
	@Qualifier("selectDaoImpl")
	private SelectDao selectDao;
	@Autowired
	@Qualifier("classNameDaoImpl")
	private ClassNameDao classNameDao;
	@Autowired
	private TeachingPlanService teachingPlanService;
	/**
	 * 
	 * @Description: 登录验证
	 * @param @param studentId 学生学号
	 * @param @param password  密码
	 * @return Student  学生对象
	 * @author Victor
	 * @date 2017年7月3日
	 */
	public Student loginValidate(String studentId, String password){
		Student student = null;
		student = studentDao.loginValidate(studentId, password);
		return student;
	}
	/**
	 * 
	 * @Description: 获取选课学生
	 * @param @param courseId 课程id
	 * @return List<Student>  学生对象集合
	 * @author Victor
	 * @date 2017年7月4日
	 */
	public List<Student> getStudentByCourse(String courseId){
		if(courseId == null || "".equals(courseId)){
			return null;
		}
		Course course = new Course();
		List<Student> studentList = new ArrayList<Student>();
		List<Select> selectList = null;
		course.setcId(Integer.parseInt(courseId));
		selectList = selectDao.querySelectByCourse(course);
		if(selectList == null){
			return null;
		}
		for(Select sel:selectList){
			studentList.add(sel.getStudent());
		}
		return studentList;
	}
	/**
	 * 
	 * @Description: 更新学生
	 * @param @param student 学生对象
	 * @return boolean  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	@Transactional
	public boolean updateStudent(Student student){
		if(student == null){
			return false;
		}
		return studentDao.updateStudent(student);
	}
	/**
	 * 
	 * @Description: 获取未达额定学分的对象
	 * @param @param years 学期
	 * @param @param cname 班级名
	 * @return List<Unqualified>  VO对象
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public List<Unqualified> getunqualifiedStudent(String years, String cname){
		ClassName className = null;
		className = classNameDao.queryClassNameByName(cname).get(0);
		
		List<Student> studentList = null;
		studentList = studentDao.queryStudentByClassName(className);
		if(studentList.size() == 0){
			return null;
		}
		
		TeachingPlan tp = null;
		tp = teachingPlanService.getPlan(years, cname);
		
		
		List<Select> selectList = null;
		int score;
		List<Unqualified> result = new ArrayList<Unqualified>();		
		for(Student stu:studentList){
			score = 0;
			selectList = selectDao.querySelectByStudent(stu);
			if(selectList.size() == 0){
				continue;
			}
			for(Select sel:selectList){
				score+=sel.getCourse().getCredits();
			}
			if(score >= tp.getPublicElectiveScore()){
				continue;
			}
			Unqualified  VO = new Unqualified();
			VO.setStudentId(stu.getsId());
			VO.setStudentName(stu.getsName());
			VO.setClassName(stu.getClassName().getcName());
			VO.setNowCredits(score);
			VO.setAimCredits(tp.getPublicElectiveScore());
			result.add(VO);
		}
		return result;
	}
	/**
	 * 
	 * @Description: 添加学生
	 * @param @param stu 学生对象
	 * @return boolean  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	@Transactional
	public boolean addStudent(Student stu){
		if(stu == null){
			return false;
		}
		return studentDao.addStudent(stu);
	}
	/**
	 * 
	 * @Description: 查询学生信息
	 * @param @param sid 学号
	 * @return Student  
	 * @throws
	 * @author Victor
	 * @date 2017年7月7日
	 */
	public Student getStudent(String sid){
		if("".equals(sid)){
			return null;
		}
		Student student = null;
		student = studentDao.queryStudentBySid(sid);
		return student;
	}
	
	
	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public SelectDao getSelectDao() {
		return selectDao;
	}
	public void setSelectDao(SelectDao selectDao) {
		this.selectDao = selectDao;
	}
	public ClassNameDao getClassNameDao() {
		return classNameDao;
	}
	public void setClassNameDao(ClassNameDao classNameDao) {
		this.classNameDao = classNameDao;
	}
	public TeachingPlanService getTeachingPlanService() {
		return teachingPlanService;
	}
	public void setTeachingPlanService(TeachingPlanService teachingPlanService) {
		this.teachingPlanService = teachingPlanService;
	}
	
	

	
	
	

}
