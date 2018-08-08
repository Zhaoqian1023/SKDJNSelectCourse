package com.po;

import java.io.Serializable;

/**
 * 
 * ClassName: Select 
 * @Description: 选课记录
 * @author Victor
 * @date 2017年6月29日
 */
@SuppressWarnings("serial")
public class Select implements Serializable {
	//记录编号
	private int sId;
	//选课学生
	private Student student;
	//选择课程
	private Course course;
	public Select() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Select(int sId, Student student, Course course) {
		super();
		this.sId = sId;
		this.student = student;
		this.course = course;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	

}
