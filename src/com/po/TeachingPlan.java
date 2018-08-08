package com.po;

import java.io.Serializable;

/**
 * 
 * ClassName: TeachingPlan 
 * @Description: 教学计划，按班级规定每学年/学期的额定学分
 * @author Victor
 * @date 2017年6月29日
 */
@SuppressWarnings("serial")
public class TeachingPlan implements Serializable {
	//记录编号
	private int tId;
	//班级
	private ClassName className;
	//学期学年
	private String years;
	//必修学分
	private int requiredScore;
	//系选学分
	private int electiveScore;
	//公选学分
	private int publicElectiveScore;
	public TeachingPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeachingPlan(int tId, ClassName className, String years,
			int requiredScore, int electiveScore, int publicElectiveScore) {
		super();
		this.tId = tId;
		this.className = className;
		this.years = years;
		this.requiredScore = requiredScore;
		this.electiveScore = electiveScore;
		this.publicElectiveScore = publicElectiveScore;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public ClassName getClassName() {
		return className;
	}
	public void setClassName(ClassName className) {
		this.className = className;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public int getRequiredScore() {
		return requiredScore;
	}
	public void setRequiredScore(int requiredScore) {
		this.requiredScore = requiredScore;
	}
	public int getElectiveScore() {
		return electiveScore;
	}
	public void setElectiveScore(int electiveScore) {
		this.electiveScore = electiveScore;
	}
	public int getPublicElectiveScore() {
		return publicElectiveScore;
	}
	public void setPublicElectiveScore(int publicElectiveScore) {
		this.publicElectiveScore = publicElectiveScore;
	}
	
	
	
	
	
}
