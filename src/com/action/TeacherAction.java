/**  
 * @Title: TeacherAction.java
 * @Package com.action
 * @Description: TODO
 * @author Victor
 * @date 2017年7月3日
 */
package com.action;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.po.ClassName;
import com.po.Course;
import com.po.Message;
import com.po.Student;
import com.po.Teacher;
import com.service.CourseService;
import com.service.MessageService;
import com.service.StudentService;
import com.service.TeacherService;
import com.util.JsonUtil;

/**
 * ClassName: TeacherAction 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月3日
 */
@Controller("teacherAction")
public class TeacherAction extends BaseAction {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private MessageService messageService;
	
	private String teacherId;
	private String password;
	private String password1;
	
	private String page;
	private Course courses;
	
	private String courseName;
	private int credits;
	private String time;
	private String years;
	private int maxCount;
	private String category;
	private String details;
	private String[] openClass;
	
	private List<Course> data;
	private String courseId;
	private String studentId;
	
	private List<Student> studentData;
	/**
	 * 
	 * @Description: 普通教师登录验证
	 * @param @return   
	 * @return String  
	 * @author Victor
	 * @date 2017年7月3日
	 */
	public String login(){
		if(teacherId == null ||"".equals(teacherId) ||password == null || "".equals(password)){
			JsonUtil.sendError();
			return NONE;
		}
		Teacher teacher = null;
		int rank = 2;
		teacher = teacherService.loginValidate(teacherId, password, rank);
		
		if(teacher == null){
			JsonUtil.sendError();
		}else{
			super.getSession().setAttribute("teacher", teacher);
			JsonUtil.sendSuccess();
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
			return "Teacher_Redirect";
		}
		if(password.equals(password1)){
			Teacher teacherTemp = (Teacher) super.getSession().getAttribute("teacher");
			teacherTemp.setPassword(password);
			boolean result = false;
			result = teacherService.updateTeacher(teacherTemp);
			if(result){
				super.getSession().removeAttribute("teacher");
				page = "../login_teacher";
			}else{
				page = "changeerror";
			}
		}
		return "Teacher_Redirect";
	}
	/**
	 * 
	 * @Description: 退出登录
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String quitTeacher(){
		super.getSession().removeAttribute("teacher");
		page = "../login_teacher";
		return "Teacher_Redirect";
	}
	/**
	 * 
	 * @Description: 教师提交选课申请
	 * @return String  
	 * @author Victor
	 * @date 2017年7月4日
	 */
	public String applicationCourse(){
		if("".equals(courseName) || openClass.length == 0){
			page = "error";
			return "Teacher_Redirect";
		}
		Set<ClassName> classNameSet = new HashSet<ClassName>();
		Teacher teacher = null;
		teacher = (Teacher)super.getSession().getAttribute("teacher");
		if(teacher == null){
			page = "error";
			return "Teacher_Redirect";
		}
		int classId = 0;
		for(Object obj:openClass){
			classId = Integer.parseInt(obj.toString());
			ClassName className = new ClassName();
			className.setcId(classId);
			classNameSet.add(className);
		}
		Course course = new Course();
		course.setcName(courseName);
		course.setCredits(credits);
		course.setDetails(details);
		course.setMaxCount(maxCount);
		course.setCategory(category);
		course.setYears(years);
		course.setTime(time);
		course.setOpenClass(classNameSet);
		course.setTeachers(teacher);
		boolean result = courseService.addApplicationCourse(course);
		if(result){
			page = "success";
		}else{
			page = "error";
		}
		return "Teacher_Redirect";
	}
	/**
	 * 
	 * @Description: 获取教师申请过得课程
	 * @return String  
	 * @author Victor
	 * @date 2017年7月4日
	 */
	public String getCourse(){
		Teacher teacher = null;
		teacher =(Teacher) super.getSession().getAttribute("teacher");
		if(teacher == null){
			return "error";
		}
		data = courseService.getPassCourse(teacher);
		return "Teacher_Success";
	}
	/**
	 * 
	 * @Description: 获取课程详情
	 * @return String  
	 * @author Victor
	 * @date 2017年7月4日
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
		courses = courseService.getDetail(cId);
		return "Teacher_Success";
	}
	
	/**
	 * 
	 * @Description: 获取选课学生信息
	 * @return String  
	 * @author Victor
	 * @date 2017年7月4日
	 */
	public String getSelectStudent(){
		if(courseId == null || "".equals(courseId)){
			return "error";
		}
		studentData = studentService.getStudentByCourse(courseId);
		
		return "Teacher_Success";
	}
	/**
	 * 
	 * @Description: 驳回选课学生
	 * @return String  
	 * @author Victor
	 * @date 2017年7月4日
	 */
	public String deleteSelect(){
		if("".equals(courseId) || "".equals(studentId)){
			JsonUtil.sendError();
			return NONE;
		}
		boolean resultCourse = false;
		boolean resultMessage = false;
		Course courseTemp = null;
		Teacher teacherTemp = null;
		
		teacherTemp =(Teacher) super.getSession().getAttribute("teacher");
		courseTemp = courseService.getDetail(Integer.parseInt(courseId));
		
		Message message = new Message();
		message.setAimShow(studentId);
		message.setContent("课程别任课老师驳回，详情请联系任课教师");
		message.setHead(courseTemp.getcName()+"课程驳回");
		message.setPublishMan(teacherTemp);
		
		resultMessage = messageService.addMessage(message);
		resultCourse = courseService.deleteSelectStudent(courseId, studentId);
		
		if(resultCourse && resultMessage){
			JsonUtil.sendSuccess();
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	
	
	
	
	
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String[] getOpenClass() {
		return openClass;
	}
	public void setOpenClass(String[] openClass) {
		this.openClass = openClass;
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
	public Course getCourses() {
		return courses;
	}
	public void setCourses(Course courses) {
		this.courses = courses;
	}
	public List<Student> getStudentData() {
		return studentData;
	}
	public void setStudentData(List<Student> studentData) {
		this.studentData = studentData;
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
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	
	
	
	
	
	

}
