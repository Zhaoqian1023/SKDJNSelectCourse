<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	  <link rel="shortcut icon" href="<%=basePath %>manager/img/favicon.ico">
	  <!-- END SHORTCUT ICON -->
	  
      <title>操作失败</title>
	  
	  <!-- BEGIN STYLESHEET --> 
		<link href="<%=basePath %>manager/css/bootstrap.min.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
		<link href="<%=basePath %>manager/css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
		<link href="<%=basePath %>manager/assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON STYLESHEET -->
		<link href="<%=basePath %>manager/css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
		<link href="<%=basePath %>manager/css/style-responsive.css" rel="stylesheet"><!-- THEME BASIC RESPONSIVE  CSS -->
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
            <h2>操作失败！</h2>
            <p class="page-404"><a href="<%=basePath %>teacher/index_teacher.jsp">返回主页</a></p>
         </section>
		 <!-- END MAIN CONTENT --> 
      </div>
   </body>
</html>
