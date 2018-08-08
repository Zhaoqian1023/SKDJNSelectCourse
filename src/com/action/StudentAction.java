/**  
 * @Title: StudentAction.java
 * @Package com.action
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
package com.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.po.Course;
import com.po.Student;
import com.service.CourseService;
import com.service.StudentService;
import com.util.JsonUtil;

/**
 * ClassName: StudentAction 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月30日
 */
@Controller("studentAction")
public class StudentAction extends BaseAction{
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	private String studentId;
	private String password;
	
	private String page;
	private String years;
	private List<Course> data;
	
	private String courseId;
	private Course course;
	private int selectFlag;
	
	private String password1;
	
	/**
	 * 
	 * @Description:  登录验证，将学生对象放在session中
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Victor
	 * @date 2017年7月2日
	 */
	public String login(){
		if(studentId == null || password == null || "".equals(studentId) || "".equals(password)){
			JsonUtil.sendError();
			return NONE;
		}
		if(studentId.length() != 12 ){
			JsonUtil.sendError();
			return NONE;
		}
		Student student = null;
		student = studentService.loginValidate(studentId, password);
		if(student != null ){
			HttpSession session =  super.getSession();
			session.setAttribute("student", student);
			JsonUtil.sendSuccess();
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	/**
	 * 
	 * @Description: 修改密码
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String updatePwd(){
		if("".equals(password1) || "".equals(password)){
			page = "changeerror";
			return "Student_Redirect";
		}
		if(password.equals(password1)){
			Student studentTemp =(Student)super.getSession().getAttribute("student"); 
			studentTemp.setPassword(password);
			boolean result = false;
			result = studentService.updateStudent(studentTemp);
			if(result){
				super.getSession().removeAttribute("student");
				page = "../login_student";
			}else{
				page = "changeerror";
			}
		}
		
		return "Student_Redirect";
	}
	/**
	 * 
	 * @Description: 退出登录
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String quitStudent(){
		super.getSession().removeAttribute("student");
		page = "../login_student";
		return "Student_Redirect";
	}
	
	/**
	 * 
	 * @Description: 学生根据学期获取所有可选（审核通过）课程
	 * @return String  
	 * @author Victor
	 * @date 2017年7月2日
	 */
	public String getAllCourse(){
		if(page == null || "".equals(page) || years == null || "".equals(years)){
			return "error";
		}
		int checkState = 1;
		data = courseService.getAllCourseByChecked(years, checkState);
		return "Student_Success";
	}
	/**
	 * 
	 * @Description: 查看课程详情，根据课程编号
	 * @return String  
	 * @author Victor
	 * @date 2017年7月2日
	 */
	public String getCourseDetail(){
		if(courseId == null || "".equals(courseId)){
			return "error";
		}
		int cId = 0;
		try {
			cId = Integer.parseInt(courseId);
		} catch (NumberFormatException e) {
			return "error";
		}
		course = courseService.getDetail(cId);
		Student student = null;
		student = (Student) super.getSession().getAttribute("student");
		selectFlag = courseService.isSelect(student, course);
		return "Student_Success";
	}
	/**
	 * 
	 * @Description: 学生选课
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Victor
	 * @date 2017年7月3日
	 */
	public String selectCourse(){
		if(courseId == null || "".equals(courseId)){
			page = "selecterror";
			return "Student_Redirect";
		}
		Student student = null;
		student = (Student) super.getSession().getAttribute("student");
		if(student == null){
			page = "selecterror";
			return "Student_Redirect";
		}
		int tempCid = Integer.parseInt(courseId);
		boolean flag = false;
		flag = courseService.selectCourse(student.getsId(), tempCid);
		if(flag){
			page = "selectsuccess";
		}else{
			page = "selecterror";
		}
		return "Student_Redirect";
	}
	/**
	 * 
	 * @Description: 学生查看指定学期已选课程
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author Victor
	 * @date 2017年7月3日
	 */
	public String allreadyCourse(){
		Student student = null;
		student = (Student) super.getSession().getAttribute("student");
		if(years == null || "".equals(years) ||student == null){
			return "error";
		}
		data = courseService.getAllreadyCourse(student, years);
		return "Student_Success";
	}
	/**
	 * 
	 * @Description: 获取已选课程详情
	 * @return String  
	 * @author Victor
	 * @date 2017年7月4日
	 */
	public String getAllreadyCourseDetail(){
		if(courseId == null || "".equals(courseId)){
			return "error";
		}
		int cId = 0;
		try {
			cId = Integer.parseInt(courseId);
		} catch (NumberFormatException e) {
			return "error";
		}
		course = courseService.getDetail(cId);
		return "Student_Success";
	}
	
	

	
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public List<Course> getData() {
		return data;
	}

	public void setData(List<Course> data) {
		this.data = data;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getSelectFlag() {
		return selectFlag;
	}
	public void setSelectFlag(int selectFlag) {
		this.selectFlag = selectFlag;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	

}
