<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="true" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- BEGIN META -->
	  <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="">
      <meta name="author" content="Custom Theme">
	  <!-- END META -->
     
      <!-- BEGIN SHORTCUT ICON -->
	  <link rel="shortcut icon" href="<%=basePath %>student/img/favicon.ico">
	  <!-- END SHORTCUT ICON -->
	  
      <title>404</title>
	  
	  <!-- BEGIN STYLESHEET --> 
		<link href="<%=basePath %>student/css/bootstrap.min.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
		<link href="<%=basePath %>student/css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
		<link href="<%=basePath %>student/assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON STYLESHEET -->
		<link href="<%=basePath %>student/css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
		<link href="<%=basePath %>student/css/style-responsive.css" rel="stylesheet"><!-- THEME BASIC RESPONSIVE  CSS -->
      <!--[if lt IE 9]>
      <script src="manager/js/html5shiv.js"></script>
      <script src="manager/js/respond.min.js"></script>
      <![endif]-->
	  <!-- END STYLESHEET --> 
   </head>
   <body class="body-404">
      <div class="container">
	     <!-- BEGIN MAIN CONTENT --> 
         <section class="error-wrapper">
            <h2>页面找不到啦!*_*</h2>
            <h2 style="font-size:30px">The page could not be found!*_*</h2>
            <p class="page-404">页面上有一些错误</br>There are some errors on the page</br><a href="<%=basePath %>home.jsp"><h3>返回主页<br>Return to Home</h3></a></p>
         </section>
		 <!-- END MAIN CONTENT --> 
      </div>
   </body>
</html>
