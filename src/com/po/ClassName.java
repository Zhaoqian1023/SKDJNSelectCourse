package com.po;

import java.io.Serializable;

/**
 * 
 * ClassName: ClassName 
 * @Description: 班级类
 * @author Victor
 * @date 2017年6月29日
 */
@SuppressWarnings("serial")
public class ClassName implements Serializable {
	//班号
	private int cId;
	//班级名
	private String cName;
	//班级英文名
	private String englishName;
	public ClassName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassName(int cId, String cName, String englishName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.englishName = englishName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	
	
	
	

}
