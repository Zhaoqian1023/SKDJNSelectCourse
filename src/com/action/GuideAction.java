/**  
 * @Title: GuideAction.java
 * @Package com.action
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
package com.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.po.Teacher;
import com.service.CourseService;
import com.service.StudentService;
import com.service.TeacherService;
import com.util.JsonUtil;
import com.vo.PeopleNumVo;
import com.vo.Unqualified;

/**
 * ClassName: GuideAction 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
@Controller("guideAction")
public class GuideAction extends BaseAction {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	
	private String guideId;
	private String password;
	private String password1;
	
	private String page;
	private String years;
	
	private List<PeopleNumVo> peopleVoList;
	private List<Unqualified> unqualifiedList;
	private String className;
	
	/**
	 * 
	 * @Description:  辅导员登录
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String login(){
		if(guideId == null || password == null || "".equals(password) || "".equals(guideId)){
			JsonUtil.sendError();
			return NONE;
		}
		Teacher guide = null;
		int rank = 1;
		guide = teacherService.loginValidate(guideId, password, rank);
		if(guide == null ){
			JsonUtil.sendError();
		}else{
			super.getSession().setAttribute("guide", guide);
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
			return "Guide_Redirect";
		}
		if(password.equals(password1)){
			Teacher guideTemp = (Teacher) super.getSession().getAttribute("guide");
			guideTemp.setPassword(password);
			boolean result = false;
			result = teacherService.updateTeacher(guideTemp);
			if(result){
				super.getSession().removeAttribute("guide");
				page = "../login_guide";
			}else{
				page = "changeerror";
			}
		}
		return "Guide_Redirect";
	}
	/**
	 * 
	 * @Description: 退出登录
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String quitGuide(){
		super.getSession().removeAttribute("guide");
		page = "../login_guide";
		return "Guide_Redirect";
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
		return "Guide_Success";
	}
	/**
	 * 
	 * @Description: 获得未达到额定学分学生信息
	 * @return String  
	 * @author Victor
	 * @date 2017年7月6日
	 */
	public String getUnqualified(){
		if("".equals(years) || "".equals(className)){
			return "error";
		}
		unqualifiedList = studentService.getunqualifiedStudent(years,className);
		return "Guide_Success";
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

	public String getGuideId() {
		return guideId;
	}

	public void setGuideId(String guideId) {
		this.guideId = guideId;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public List<PeopleNumVo> getPeopleVoList() {
		return peopleVoList;
	}
	public void setPeopleVoList(List<PeopleNumVo> peopleVoList) {
		this.peopleVoList = peopleVoList;
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
	public List<Unqualified> getUnqualifiedList() {
		return unqualifiedList;
	}
	public void setUnqualifiedList(List<Unqualified> unqualifiedList) {
		this.unqualifiedList = unqualifiedList;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	

}
