package com.po;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * ClassName: Course 
 * @Description: 课程类
 * @author Victor
 * @date 2017年6月29日
 */
@SuppressWarnings("serial")
public class Course implements Serializable {
	//记录编号
	private int cId;
	//课程代码
	private String cNo;
	//课程名
	private String cName;
	//类别
	private String category;
	//学分
	private int credits;
	//总学时如36学时
	private String time;
	//上课时间（周）如1-8,7-8;9-16,7-8,表示1-8周7-8节课上课
	private String schoolTime;
	//学年学期如2016-2017/2
	private String years;
	//选课注意事项，细节详情
	private String details;
	//最大人数
	private int maxCount;
	//开放班级
	private Set<ClassName> openClass;
	//任课教师
	private Teacher teachers;
	//考试周（区别是否需要安排补考），公选课为0
	private int examTime;
	//审核状态，2代表审核未通过,1代表审核通过，0代表未审核
	private int checkState;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int cId, String cNo, String cName, String category,
			int credits, String time, String schoolTime, String years,
			String details, int maxCount, Set<ClassName> openClass,
			Teacher teachers, int examTime, int checkState) {
		super();
		this.cId = cId;
		this.cNo = cNo;
		this.cName = cName;
		this.category = category;
		this.credits = credits;
		this.time = time;
		this.schoolTime = schoolTime;
		this.years = years;
		this.details = details;
		this.maxCount = maxCount;
		this.openClass = openClass;
		this.teachers = teachers;
		this.examTime = examTime;
		this.checkState = checkState;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getSchoolTime() {
		return schoolTime;
	}
	public void setSchoolTime(String schoolTime) {
		this.schoolTime = schoolTime;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public Set<ClassName> getOpenClass() {
		return openClass;
	}
	public void setOpenClass(Set<ClassName> openClass) {
		this.openClass = openClass;
	}
	public Teacher getTeachers() {
		return teachers;
	}
	public void setTeachers(Teacher teachers) {
		this.teachers = teachers;
	}
	public int getExamTime() {
		return examTime;
	}
	public void setExamTime(int examTime) {
		this.examTime = examTime;
	}
	public int getCheckState() {
		return checkState;
	}
	public void setCheckState(int checkState) {
		this.checkState = checkState;
	}
	
	
	

}
