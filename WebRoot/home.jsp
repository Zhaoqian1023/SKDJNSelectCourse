<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


 <html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>山东科技大学济南校区选课系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FREEHTML5" />

    <!-- Animate.css -->
    <link rel="stylesheet" href="<%=basePath %>teacher/css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="<%=basePath %>teacher/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="<%=basePath %>teacher/css/bootstrap.css">
    <!-- Superfish -->
    <link rel="stylesheet" href="<%=basePath %>teacher/css/superfish.css">

    <link rel="stylesheet" href="<%=basePath %>teacher/css/stylefont.css">


    <!-- Modernizr JS -->
    <script src="<%=basePath %>teacher/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="<%=basePath %>teacher/js/respondfont.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="fh5co-wrapper">
    <div id="fh5co-page">
        <div id="fh5co-header">
            <header id="fh5co-header-section">
                <div class="container">
                    <div class="nav-header">
                        <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
                        <h1 id="fh5co-logo"><a href="<%=basePath %>home.jsp"><span>山东科技大学</span></a></h1>
                    </div>
                </div>
            </header>

        </div>


        <div class="fh5co-hero">
            <div class="fh5co-overlay"></div>
            <div class="fh5co-cover text-center" data-stellar-background-ratio="0.5" style="background-image: url(<%=basePath %>teacher/images/skdheng01.jpg);">
                <div class="desc animate-box">
                    <h2>选课系统</h2>
                    
                    <span>济南校区</span>
                    <span style="font-size: medium"><a class="btn btn-primary" href="teacher/login_teacher.jsp">开始办公/start</a></span>
                    <span style="font-size: medium"><a class="btn btn-primary" href="student/login_student.jsp">学生入口/Student Login</a></span>
                </div>
            </div>
        </div>

        
        <footer>
            <div id="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 text-center">
                            <p class="fh5co-social-icons">
                                <a href="#"><i class="icon-twitter2"></i></a>
                                <a href="#"><i class="icon-facebook2"></i></a>
                                <a href="#"><i class="icon-instagram"></i></a>
                                <a href="#"><i class="icon-dribbble2"></i></a>
                                <a href="#"><i class="icon-youtube"></i></a>
                            </p>
                            <p>Copyright &copy; 2016 <a href="http://www.ustsd.edu.cn">山东科技大学济南校区</a>教科部版权所有</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

    </div>
    <!-- END fh5co-page -->

</div>
<!-- END fh5co-wrapper -->

<!-- jQuery -->


<script src="<%=basePath %>teacher/js/jquery.js"></script>
<!-- jQuery Easing -->
<script src="<%=basePath %>teacher/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="<%=basePath %>teacher/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="<%=basePath %>teacher/js/jquery.waypoints.min.js"></script>
<!-- Stellar -->
<script src="<%=basePath %>teacher/js/jquery.stellar.min.js"></script>
<!-- Superfish -->
<script src="<%=basePath %>teacher/js/hoverIntent.js"></script>
<script src="<%=basePath %>teacher/js/superfish.js"></script>

<!-- Main JS (Do not remove) -->
<script src="<%=basePath %>teacher/js/mainfont.js"></script>

</body>
</html>

