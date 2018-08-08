/**  
 * @Title: Log.java
 * @Package com.po
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.po;

import java.io.Serializable;

/**
 * ClassName: Log 
 * @Description: 系统开放时间日志
 * @author Victor
 * @date 2017年6月29日
 */
@SuppressWarnings("serial")
public class Log implements Serializable {
	//记录标记
	private int lId;
	//开始时间
	private String beginTime;
	//结束时间
	private String endTime;
	//学年学期
	private String years;
	//备注说明，开课申请还是选课申请
	private String remark;
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Log(int lId, String beginTime, String endTime, String years,
			String remark) {
		super();
		this.lId = lId;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.years = years;
		this.remark = remark;
	}
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
