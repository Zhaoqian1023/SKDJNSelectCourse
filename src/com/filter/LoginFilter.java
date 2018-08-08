package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.po.Student;
import com.po.Teacher;

@SuppressWarnings("serial")
public class LoginFilter extends HttpServlet implements Filter {
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private HttpSession session = null;
	private String uri = null;
	private String contextPath = null;
	private Teacher teacher = null;
	private Student student = null;
	private Teacher manager = null;
	private Teacher guide = null;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		request =(HttpServletRequest) req;
		response = (HttpServletResponse) resp;
		session = request.getSession();   
		uri = request.getServletPath();
		contextPath=request.getContextPath();//根
		
		
		 if(uri.equals("")){
			 uri+="/";
		 }
		 if(!(uri.indexOf("/css/")>-1 || uri.indexOf("/assets/")>-1 
				 || uri.indexOf("/fonts/")>-1
				 || uri.indexOf("/images/")>-1
				 || uri.indexOf("/img/")>-1
				 || uri.indexOf("/js/")>-1)){
			 teacher=(Teacher) session.getAttribute("teacher");
			 student = (Student)session.getAttribute("student");
			 manager = (Teacher)session.getAttribute("manager");
			 guide = (Teacher)session.getAttribute("guide");
			 if(uri.indexOf("/teacher/")>-1 && !uri.endsWith("login.action") && !uri.endsWith("login_teacher.jsp")
					 ){
				 if(teacher == null){//转入管理员登陆页面  
		               response.sendRedirect(contextPath+"/teacher/login_teacher.jsp"); 
		               return;  
				 }  
			 }
			 if(uri.indexOf("/student/")>-1 && !uri.endsWith("login.action") && !uri.endsWith("login_student.jsp")
						){
				 if(student == null){//转入学生登陆页面  
					 response.sendRedirect(contextPath+"/student/login_student.jsp"); 
					 return;  
				 }   
			 }
			 if(uri.indexOf("/manager/")>-1 && !uri.endsWith("login.action") && !uri.endsWith("login_manager.jsp")
						){
				 if(manager == null){//转入学生登陆页面  
					 response.sendRedirect(contextPath+"/manager/login_manager.jsp"); 
					 return;  
				 }   
			 }
			 if(uri.indexOf("/guide/")>-1 && !uri.endsWith("login.action") && !uri.endsWith("login_guide.jsp")
						){
				 if(guide == null){//转入学生登陆页面  
					 response.sendRedirect(contextPath+"/guide/login_guide.jsp"); 
					 return;  
				 }   
			 }
		 }
         chain.doFilter(req, resp);    
		
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	} 

}
