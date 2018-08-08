package com.po;

import java.io.Serializable;

/**
 * 
 * ClassName: Message 
 * @Description: 新闻公告，可针对单个学生发送消息
 * @author Victor
 * @date 2017年6月29日
 */
@SuppressWarnings("serial")
public class Message implements Serializable {
	private int mId;
	//显示对象
	private String aimShow;
	//消息主题
	private String head;
	//信息内容
	private String content;
	//发布时间
	private String times;
	private Teacher publishMan;
	//消息状态,可用于学生标记该条信息为已查阅，0代表未读（公告默认为0,且不可修改），1代表已读（用于学生标记驳回信息）
	private int flag;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int mId, String aimShow, String head, String content,
			String times, Teacher publishMan, int flag) {
		super();
		this.mId = mId;
		this.aimShow = aimShow;
		this.head = head;
		this.content = content;
		this.times = times;
		this.publishMan = publishMan;
		this.flag = flag;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getAimShow() {
		return aimShow;
	}
	public void setAimShow(String aimShow) {
		this.aimShow = aimShow;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Teacher getPublishMan() {
		return publishMan;
	}
	public void setPublishMan(Teacher publishMan) {
		this.publishMan = publishMan;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	

}
