package com.po;

import java.io.Serializable;

/**
 * 
 * ClassName: Teacher 
 * @Description: 教师类
 * @author Victor
 * @date 2017年6月29日
 */
@SuppressWarnings("serial")
public class Teacher implements Serializable {
	//教师编号
	private int tId;
	//教师姓名
	private String tName;
	//所在教研室
	private String position;
	//职称
	private String title;
	//所在院系
	private String dept;
	//登录密码
	private String password;
	//权限级别：0-教务管理员，1-辅导员，2-任课教师
	private int rank;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int tId, String tName, String position, String title,
			String dept, String password, int rank) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.position = position;
		this.title = title;
		this.dept = dept;
		this.password = password;
		this.rank = rank;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

}
