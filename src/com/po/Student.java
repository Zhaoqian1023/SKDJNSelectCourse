package com.po;

import java.io.Serializable;

/**
 * 
 * ClassName: Student 
 * @Description: 学生类
 * @author Victor
 * @date 2017年6月29日
 */

@SuppressWarnings("serial")
public class Student implements Serializable {
	//学号
	private String sId;
	//姓名
	private String sName;
	//英文名
	private String englishName;
	//性别
	private String sex;
	//身份证号
	private String number;
	//所在班级
	private ClassName className;
	//所在院系
	private String colleages;
	//备注
	private String note;
	//学生状态 如在校、离校、休学
	private String status;
	//登录密码
	private String password;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sId, String sName, String englishName, String sex,
			String number, ClassName className, String colleages, String note,
			String status, String password) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.englishName = englishName;
		this.sex = sex;
		this.number = number;
		this.className = className;
		this.colleages = colleages;
		this.note = note;
		this.status = status;
		this.password = password;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
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
	public ClassName getClassName() {
		return className;
	}
	public void setClassName(ClassName className) {
		this.className = className;
	}
	public String getColleages() {
		return colleages;
	}
	public void setColleages(String colleages) {
		this.colleages = colleages;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
