/**  
 * @Title: PeopleNumVo.java
 * @Package com.vo
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
package com.vo;

/**
 * ClassName: PeopleNumVo 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
public class PeopleNumVo {
	private String courseName;
	private String teacherName;
	private int count;
	public PeopleNumVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PeopleNumVo(String courseName, String teacherName, int count) {
		super();
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.count = count;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
