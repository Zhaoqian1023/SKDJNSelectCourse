/**  
 * @Title: CourseService.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年7月2日
 */
package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CourseDao;
import com.dao.SelectDao;
import com.dao.StudentDao;
import com.po.ClassName;
import com.po.Course;
import com.po.Select;
import com.po.Student;
import com.po.Teacher;
import com.util.RandomUtil;
import com.vo.PeopleNumVo;

/**
 * ClassName: CourseService 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月2日
 */
@Service("courseService")
public class CourseService {
	
	@Autowired
	@Qualifier("courseDaoImpl")
	private CourseDao courseDao;
	@Autowired
	@Qualifier("selectDaoImpl")
	private SelectDao selectDao;
	@Autowired
	@Qualifier("studentDaoImpl")
	private StudentDao studentDao;
	
	/**
	 * 
	 * @Description: 根据状态获取课程
	 * @param @param years 学期学年
	 * @param @param checkState 课程状态（已审核）
	 * @return List<Course> 课程集合  
	 * @author Victor
	 * @date 2017年7月3日
	 */
	public List<Course> getAllCourseByChecked(String years, int checkState){
		List<Course> data = null;
		data = courseDao.queryCourseByStateAndYears(years,checkState);
		return data;
	}
	
	/**
	 * 
	 * @Description: 获取课程详细信息
	 * @param @param cId 课程id
	 * @return Course 课程对象  
	 * @author Victor
	 * @date 2017年7月3日
	 */
	public Course getDetail(int cId){
		Course course = null;
		course = courseDao.queryCourseByCid(cId);
		return course;
	}
	
	/**
	 * 
	 * @Description: 判断课程是否可选
	 * @param @param student 学生对象
	 * @param @param course 课程对象
	 * @return int 1为可选，0为不可选 
	 * @author Victor
	 * @date 2017年7月3日
	 */
	public int isSelect(Student student,Course course){
		if(student == null || course == null){
			return 0;//不可选
		}
		List<Course> courseList = new ArrayList<Course>();
		List<Select> selectList = null;
		Set<ClassName> classNameSet = null;
		int tempFlag = 0;
		classNameSet = course.getOpenClass();
		for(ClassName cn:classNameSet){//判断是否可以属于可选班级学生
			if(cn.getcId() == student.getClassName().getcId()){
				tempFlag = 1;//可选
				break;
			}
		}
		if(tempFlag == 0){
			return 0;//不可选
		}
		long nowCount = selectDao.queryCountByCourse(course);
		int maxCount = course.getMaxCount();
		if(maxCount <= nowCount){//达到上限人数
			return 0;//不可选
		}
		
		selectList = selectDao.querySelectByStudent(student);
		for(Select sel:selectList){
			courseList.add(sel.getCourse());
		}
		if(courseList.contains(course)){//判断是否已选
			return 0;//不可选
		}
		return 1;//可选
	}
	
	/**
	 * 
	 * @Description: 学生选课
	 * @param @param studentId 学号
	 * @param @param courseId 课程id
	 * @return boolean  选课结果成功与否
	 * @author Victor
	 * @date 2017年7月3日
	 */
	@Transactional
	public boolean selectCourse(String studentId, int courseId){
		Student student = new Student();
		student.setsId(studentId);
		student = studentDao.queryStudentBySid(studentId);
		if(!"在校".equals(student.getStatus())){
			return false;
		}
		Course course = new Course();
		course.setcId(courseId);
		
		Select select = new Select();
		select.setStudent(student);
		select.setCourse(course);
		
		boolean result = false;
		result = selectDao.addSelect(select);
		return result;
	}
	
	/**
	 * 
	 * @Description: 查看已选课程
	 * @param @param student 学生对象
	 * @param @param years 学年学期
	 * @return List<Course> 该学生已选课程集合  
	 * @author Victor
	 * @date 2017年7月3日
	 */
	public List<Course> getAllreadyCourse(Student student, String years){
		if(student == null ||years == null ||"".equals(years)){
			return null;
		}
		List<Course> courseList = new ArrayList<Course>();
		List<Select> selectList = null;
		selectList = selectDao.querySelectByStudent(student);
		for(Select sel:selectList){
			courseList.add(sel.getCourse());
		}
		return courseList;
	}
	/**
	 * 
	 * @Description: 新增开课申请
	 * @param @param course 课程对象
	 * @return boolean  
	 * @author Victor
	 * @date 2017年7月4日
	 */
	@Transactional
	public boolean addApplicationCourse(Course course){
		if(course == null){
			return false;
		}
		course.setcNo(RandomUtil.getRandom(8));
		course.getTeachers();
		course.setCheckState(0);//状态为未审核
		return courseDao.addCourse(course);
	}
	
	/**
	 * 
	 * @Description: 通过老师获得课程
	 * @param @param teacher 教师对象
	 * @return List<Course>  课程集合
	 * @author Victor
	 * @date 2017年7月4日
	 */
	public List<Course> getPassCourse(Teacher teacher){
		if(teacher == null){
			return null;
		}
		List<Course> courseList = null;
		courseList = courseDao.queryCourseByTeacher(teacher);
		return courseList;
	}
	/**
	 * 
	 * @Description: 驳回学生选课申请
	 * @param @param courseId 课程号
	 * @param @param studentId 学号
	 * @return boolean  
	 * @author Victor
	 * @date 2017年7月5日
	 */
	@Transactional
	public boolean deleteSelectStudent(String courseId, String studentId){
		int cid = 0;
		try {
			cid =Integer.parseInt(courseId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return false;
		}
		Student student = new Student();
		student.setsId(studentId);
		Course course = new Course();
		course.setcId(cid);
		Select select = null;
		select = selectDao.querySelectByCourseAndStudent(course, student);
		return selectDao.deleteSelect(select);
	}
	/**
	 * 
	 * @Description: 更新课程信息（针对审核通过课程）
	 * @param @param course 课程对象
	 * @return boolean  
	 * @author Victor
	 * @date 2017年7月5日
	 */
	@Transactional
	public boolean updateCourse(Course course){
		if(course == null){
			return false;
		}
		Course tempCourse = null;
		tempCourse = courseDao.queryCourseByCid(course.getcId());
		tempCourse.setExamTime(course.getExamTime());
		tempCourse.setSchoolTime(course.getSchoolTime());
		tempCourse.setCheckState(course.getCheckState());
		return courseDao.updateCourse(tempCourse);
	}
	/**
	 * 
	 * @Description: 按学期同时课程选课人数并排序
	 * @param @param years 学期学年
	 * @return List<PeopleNumVo> 排序后VO对象集合  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public List<PeopleNumVo> getNumByCourse(String years){
		List<PeopleNumVo> temp = new ArrayList<PeopleNumVo>();
		List<PeopleNumVo> temp1 = new ArrayList<PeopleNumVo>();
		List<PeopleNumVo> result = new ArrayList<PeopleNumVo>();
		List<Course> courseList = null;
		int count = 0;
		courseList = courseDao.queryCourseByStateAndYears(years, 1);
		if(courseList.size() == 0){
			return null;
		}
		
		for(Course c:courseList){
			count = (int) selectDao.queryCountByCourse(c);
			PeopleNumVo pnVO = new PeopleNumVo();
			pnVO.setCourseName(c.getcName());
			pnVO.setTeacherName(c.getTeachers().gettName());
			pnVO.setCount(count);
			temp.add(pnVO);
			temp1.add(pnVO);
		}
		for(int i = 0; i < temp.size()-1; i++){
			if(i == temp1.size()){
				break;
			}
			PeopleNumVo tempVO = new PeopleNumVo();
			tempVO = temp1.get(0);
			for(int j = 1; j < temp.size(); j++){
				if(j == temp1.size()){
					break;
				}
				if(tempVO.getCount() < temp1.get(j).getCount()){
					tempVO = temp1.get(j);
				}
			}
			result.add(tempVO);
			temp1.remove(tempVO);
		}
		return result;
	}
	
	
	
	
	
	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public SelectDao getSelectDao() {
		return selectDao;
	}
	public void setSelectDao(SelectDao selectDao) {
		this.selectDao = selectDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
