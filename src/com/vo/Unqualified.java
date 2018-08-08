/**  
 * @Title: Unqualified.java
 * @Package com.vo
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
package com.vo;

/**
 * ClassName: Unqualified 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月6日
 */
public class Unqualified {
	private String studentId;
	private String className;
	private String studentName;
	private int aimCredits;
	private int nowCredits;
	public Unqualified() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Unqualified(String studentId, String className, String studentName,
			int aimCredits, int nowCredits) {
		super();
		this.studentId = studentId;
		this.className = className;
		this.studentName = studentName;
		this.aimCredits = aimCredits;
		this.nowCredits = nowCredits;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAimCredits() {
		return aimCredits;
	}
	public void setAimCredits(int aimCredits) {
		this.aimCredits = aimCredits;
	}
	public int getNowCredits() {
		return nowCredits;
	}
	public void setNowCredits(int nowCredits) {
		this.nowCredits = nowCredits;
	}
	

}
