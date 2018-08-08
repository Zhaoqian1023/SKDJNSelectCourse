/**  
 * @Title: ManagerAction.java
 * @Package com.action
 * @Description: TODO
 * @author Victor
 * @date 2017年7月4日
 */
package com.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.po.ClassName;
import com.po.Course;
import com.po.Message;
import com.po.Student;
import com.po.Teacher;
import com.service.ClassNameService;
import com.service.CourseService;
import com.service.MessageService;
import com.service.StudentService;
import com.service.TeacherService;
import com.util.JsonUtil;
import com.vo.PeopleNumVo;

/**
 * ClassName: ManagerAction 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月4日
 */
@Controller("managerAction")
public class ManagerAction extends BaseAction {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassNameService classNameService;
	private String managerId;
	private String password;
	private String password1;
	
	private String page;
	private String years;
	private List<Course> courseList;
	
	private String courseId;
	private Course course;
	
	private String schoolTime;
	private String examTime;
	private String teacherId;
	
	private String headInfo;
	private String contentInfo;
	
	private List<Student> studentList;
	private Student studentData;
	
	private List<PeopleNumVo> peopleVoList;
	private String teacherName;
	private String position;
	private String title;
	private String dept;
	private int rank;
	
	private Teacher teacherResult;
	
	private String studentId;
	private String studentName;
	private String englishName;
	private String sex;
	private String number;
	private String colleages;
	private String className;
	private String note;
	private String status;
	/**
	 * 
	 * @Description: 登录验证
	 * @return String  
	 * @author Victor
	 * @date 2017年7月5日
	 */
	public String login(){
		if(managerId == null ||password == null || "".equals(managerId) || "".equals(password)){
			JsonUtil.sendError();
			return NONE;
		}
		Teacher teacher = null;
		int rank = 0;
		teacher = teacherService.loginValidate(managerId, password, rank);
		if(teacher != null ){
			super.getSession().setAttribute("manager", teacher);
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
			return "Manager_Redirect";
		}
		if(password.equals(password1)){
			Teacher managerTemp = (Teacher) super.getSession().getAttribute("manager");
			managerTemp.setPassword(password);
			boolean result = false;
			result = teacherService.updateTeacher(managerTemp);
			if(result){
				super.getSession().removeAttribute("manager");
				page = "../login_manager";
			}else{
				page = "changeerror";
			}
		}
		return "Manager_Redirect";
	}
	/**
	 * 
	 * @Description:退出登录
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String quitManager(){
		super.getSession().removeAttribute("manager");
		page = "../login_manager";
		return "Manager_Redirect";
	}
	/**
	 * 
	 * @Description: 获取待审核过程
	 * @return String  
	 * @author Victor
	 * @date 2017年7月5日
	 */
	public String getCheckCourse(){
		if("".equals(page) || "".equals(years)){
			return "error";
		}
		int checkState = 0;
		courseList = courseService.getAllCourseByChecked(years, checkState);
		return "Manager_Success";
	}
	/**
	 * 
	 * @Description: 获取待审核课程的详情
	 * @return String  
	 * @author Victor
	 * @date 2017年7月5日
	 */
	public String getCheckCourseDetail(){
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
		return "Manager_Success";
	}
	/**
	 * 
	 * @Description: 审核课程
	 * @return String  
	 * @author Victor
	 * @date 2017年7月5日
	 */
	public String checkCourse(){
		if("".equals(courseId)){
			return "error";
		}
		int cId;
		try {
			cId = Integer.parseInt(courseId);
		} catch (NumberFormatException e) {
			return "error";
		}
		course = courseService.getDetail(cId);
		return "Manager_Success";
	}
	/**
	 * 
	 * @Description: 提交通过审核的课程
	 * @param @return   
	 * @author Victor
	 * @date 2017年7月5日
	 */
	public String checkCoursePass(){
		if("".equals(courseId) || "".equals(examTime) || "".equals(schoolTime)){
			return "error";
		}
		Course tempCourse = new Course();
		tempCourse.setcId(Integer.parseInt(courseId));
		tempCourse.setExamTime(Integer.parseInt(examTime));
		tempCourse.setSchoolTime(schoolTime);
		tempCourse.setCheckState(1);//通过审核
		boolean result = false;
		result = courseService.updateCourse(tempCourse);
		if(result){
			page = "checksuccess";
		}else{
			page = "checkerror";
		}
		return "Manager_Redirect";
	}
	/**
	 * 
	 * @Description: 驳回申请说明
	 * @return String  
	 * @author Victor
	 * @date 2017年7月5日
	 */
	public String checkCourseReject(){
		if("".equals(courseId) || "".equals(teacherId) || "".equals(headInfo) || "".equals(contentInfo)){
			return "error";
		}
		Message message = new Message();
		message.setAimShow(teacherId);
		message.setPublishMan((Teacher)super.getSession().getAttribute("manager"));
		message.setHead(headInfo);
		message.setContent(contentInfo);
		boolean resultCourse = false;
		boolean resultMessage = false;
		Course tempCourse = new Course();
		tempCourse.setcId(Integer.parseInt(courseId));
		tempCourse.setCheckState(2);
		resultCourse = courseService.updateCourse(tempCourse);
		resultMessage = messageService.addMessage(message);
		if(resultCourse && resultMessage){
			page = "checksuccess";
		}else{
			page = "checkerror";
		}
		return "Manager_Redirect";
	}
	/**
	 * 
	 * @Description: 获取全部课程
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String getAllCourse(){
		if("".equals(years)){
			return "error";
		}
		List<Course> tempPass = null;
		List<Course> tempReject = null;
		courseList = new ArrayList<Course>();
		tempPass = courseService.getAllCourseByChecked(years, 1);
		tempReject = courseService.getAllCourseByChecked(years, 2);
		for(Course c :tempPass){
			courseList.add(c);
		}
		for(Course c :tempReject){
			courseList.add(c);
		}
		return "Manager_Success";
	}
	/**
	 * 
	 * @Description: 管理员查看课程详情，包括选课学生信息
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String getCourseDetail(){
		if(courseId == null){
			return "error";
		}
		course = courseService.getDetail(Integer.parseInt(courseId));
		studentList = studentService.getStudentByCourse(courseId);
		return "Manager_Success";
	}
	/**
	 * 
	 * @Description: 获取课程人数（排序后）
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String getPeoperNum(){
		if("".equals(years)){
			return "error";
		}
		peopleVoList = courseService.getNumByCourse(years);
		return "Manager_Success";
	}
	/**
	 * 
	 * @Description: 添加教师
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String addTeacher(){
		if("".equals(teacherId) || "".equals(teacherName)){
			page = "inputerror";
		}
		Teacher teacherTemp = new Teacher();
		teacherTemp.settId(Integer.parseInt(teacherId));
		teacherTemp.settName(teacherName);
		teacherTemp.setTitle(title);
		teacherTemp.setDept(dept);
		teacherTemp.setPosition(position);
		teacherTemp.setRank(rank);
		boolean result =teacherService.addTeacher(teacherTemp);
		if(result){
			page = "inputsuccess";
		}else{
			page = "inputerror";
		}
		return "Manager_Redirect";
	}
	/**
	 * 
	 * @Description: 查询教师
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String queryTeacher(){
		if("".equals(teacherId)){
			page = "fail";
		}
		teacherResult = teacherService.getTeacher(teacherId);
		page = "teacherupdate_manager";
		return "Manager_Success";
	}
	/**
	 * 
	 * @Description: 修改教师信息
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String updateTeacher(){
		if("".equals(teacherId) || "".equals(teacherName)){
			page = "inputerror";
		}
		Teacher temp = teacherService.getTeacher(teacherId);

		Teacher teacherTemp = new Teacher();
		teacherTemp.settId(Integer.parseInt(teacherId));
		teacherTemp.settName(teacherName);
		teacherTemp.setTitle(title);
		teacherTemp.setDept(dept);
		teacherTemp.setPosition(position);
		teacherTemp.setRank(rank);
		teacherTemp.setPassword(temp.getPassword());
		
		boolean result = false;
		result = teacherService.updateTeacher(teacherTemp);
		if(result){
			page = "true";
		}else{
			page = "fail";
		}
		return "Manager_Redirect";
	}
	/**
	 * 
	 * @Description: 生成新密码 
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String forgetPwd(){
		if(teacherId != null){
			String  newPwd=teacherService.modifyTeacherPwd(teacherId);
			List msgList =new ArrayList();
			if(!"fail".equals(newPwd)){
				msgList.add(newPwd);
				JsonUtil.sendList(msgList);
			}else{
				JsonUtil.sendError();
			}
		}else{
			JsonUtil.sendError();
		}
		return NONE;
	}
	/**
	 * 
	 * @Description: 添加学生
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String addStudent(){
		if("".equals(studentId) || "".equals(className)){
			page = "fail";
			return "Manager_Redirect";
		}
		ClassName classname = classNameService.getClassName(className);
		if(classname == null){
			page = "fail";
			return "Manager_Redirect";
		}
		Student studentTemp = new Student();
		studentTemp.setsId(studentId);
		studentTemp.setsName(studentName);
		studentTemp.setEnglishName(englishName);
		studentTemp.setSex(sex);
		studentTemp.setNumber(number);
		studentTemp.setClassName(classname);
		studentTemp.setNote(note);
		studentTemp.setStatus(status);
		studentTemp.setColleages(colleages);
		studentTemp.setPassword("");
		
		boolean result = false;
		result = studentService.addStudent(studentTemp);
		if(result){
			page = "true";
		}else{
			page = "fail";
		}
		return "Manager_Redirect";
	}
	/**
	 * 
	 * @Description: 查询学生信息
	 * @return String  
	 * @author Victor
	 * @date 2017年7月7日
	 */
	public String queryStudent(){
		if("".equals(studentId)){
			page = "fail";
		}
		studentData = studentService.getStudent(studentId);
		page = "studentupdate_manager";
		return "Manager_Success";
	}
	/**
	 * 
	 * @Description: 更新学生
	 * @return String  
	 * @author Victor
	 * @date 2017年7月7日
	 */
	public String updateStudent(){
		if("".equals(studentId) || "".equals(className)){
			page = "fail";
			return "Manager_Redirect";
		}
		ClassName classname = classNameService.getClassName(className);
		if(classname == null){
			page = "fail";
			return "Manager_Redirect";
		}
		Student student =studentService.getStudent(studentId);
		if(student == null){
			page = "fail";
			return "Manager_Redirect";
		}
		student.setsName(studentName);
		student.setEnglishName(englishName);
		student.setSex(sex);
		student.setNumber(number);
		student.setClassName(classname);
		student.setNote(note);
		student.setStatus(status);
		student.setColleages(colleages);
		
		boolean result = false;
		result = studentService.updateStudent(student);
		if(result){
			page = "true";
		}else{
			page = "fail";
		}
		return "Manager_Redirect";
	}
	
	
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
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
	public String getSchoolTime() {
		return schoolTime;
	}
	public void setSchoolTime(String schoolTime) {
		this.schoolTime = schoolTime;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public String getHeadInfo() {
		return headInfo;
	}
	public void setHeadInfo(String headInfo) {
		this.headInfo = headInfo;
	}
	public String getContentInfo() {
		return contentInfo;
	}
	public void setContentInfo(String contentInfo) {
		this.contentInfo = contentInfo;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public List<PeopleNumVo> getPeopleVoList() {
		return peopleVoList;
	}
	public void setPeopleVoList(List<PeopleNumVo> peopleVoList) {
		this.peopleVoList = peopleVoList;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public Teacher getTeacherResult() {
		return teacherResult;
	}
	public void setTeacherResult(Teacher teacherResult) {
		this.teacherResult = teacherResult;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColleages() {
		return colleages;
	}
	public void setColleages(String colleages) {
		this.colleages = colleages;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ClassNameService getClassNameService() {
		return classNameService;
	}
	public void setClassNameService(ClassNameService classNameService) {
		this.classNameService = classNameService;
	}
	public Student getStudentData() {
		return studentData;
	}
	public void setStudentData(Student studentData) {
		this.studentData = studentData;
	}
	
}
