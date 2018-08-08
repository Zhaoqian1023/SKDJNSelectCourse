/**  
 * @Title: BaseAction.java
 * @Package com.action
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


/**
 * ClassName: BaseAction 
 * @Description: TODO
 * @author Victor
 * @date 2017年6月29日
 */
public class BaseAction extends ActionSupport {
	
	public HttpSession getSession(){
		HttpSession session = null;
		session=ServletActionContext.getRequest().getSession();
		return session;
	}

}
