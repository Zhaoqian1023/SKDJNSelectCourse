<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Victor Rock">
    <title>山东科技大学济南校区选课系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.min.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
	<link href="css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON CSS -->
	<link href="css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
	<link href="css/style-responsive.css" rel="stylesheet"><!-- THEME RESPONSIVE CSS -->
	<link href="assets/morris.js-0.4.3/morris.css" rel="stylesheet"><!-- MORRIS CHART CSS -->
    <link href="css/clndr.css" rel="stylesheet">
    <script src="js/html5shiv.js">
	</script>
	<script src="js/respond.min.js">
	</script>
	<script type="text/javascript">
	function active(){
		   $("#unqualifiedStudent_guide").attr("class","active");
	   }
	</script>

  </head>
  
  <body onload="active()">
    <section id="container" class="">
    <!--header-->
     <%@ include file="publicpage/head.jsp" %>
    <!---->
        
      <!-- aside -->
      <%@ include file="publicpage/leftaside.jsp" %>
      <!---->
      <form  name="formName" action="" method="post">
        <section id="main-content">
            <!-- BEGIN WRAPPER  -->
            <section class="wrapper">
                <!-- BEGIN ROW  -->
                <div class="row">
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading">
                                <i class="fa fa-hand-o-down"> </i> <span
                                    class="label label-success" style="font-size: medium">
									未达到学分要求学生 </span>
                            </header>


                            <div id="f1" class="f1">
                                <table width="750" cellspacing="0" cellpadding="0" border="0"
                                       align="center">
                                    <tbody>
                                    <tr>
                                        <td class="Font18" width="50%" valign="middle" align="center"><font
                                                size="5" face="黑体">学生选课情况</font><br>
                                            <br></td>
                                    </tr>
                                    <tr>
                                        <td>
                                           <br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top">
                                            <table width="100%" cellspacing="0" cellpadding="0"
                                                   border="0">
                                                <tbody>
                                                <tr valign="top" align="left">
                                                    <td width="356">
                                                        <table class="LUpLines" width="100%" cellspacing="0"
                                                               cellpadding="0" border="1" align="left">
                                                            <tbody>
                                                            <tr class="Font11PtX120" valign="middle"
                                                                align="center">
                                                                <td class="RULine" width="5%" nowrap="nowrap">序号</td>
                                                                <td class="RULine" width="23%" nowrap="nowrap">学号</td>
                                                                <td class="RULine" width="32%" nowrap="nowrap">班级</td>
                                                                <td class="RULine" width="20%" nowrap="nowrap">姓名</td>
                                                                <td class="RULine" width="10%" nowrap="nowrap">目前学分</td>
                                                                <td class="RULine" width="10%" nowrap="nowrap">目标学分</td>
                                                            </tr>


                                                            <c:forEach items="${unqualifiedList }" var="att" varStatus="varstatus">
                                                            <tr class="Font8Pt" valign="top">
                                                                <td  class="RULine"  align="center"><center><input type="text"size="2" name="studentId" readonly="readonly" style="border: 0px;text-align: center" value="${varstatus.count }"></center></td>
                                                                <td  class="RULine" ><center><input type="text"size="13" name="studentId" readonly="readonly" style="border: 0px" value="${att.getStudentId() }"></center></td>
                                                                <td class="RULine" nowrap="nowrap" ><center>
                                                                    <input type="text" name="studentName" size="24" readonly="readonly" style="border: 0px" value="${att.getClassName() }"></center></td>
                                                                <td class="RULine" nowrap="nowrap" ><center>
                                                                    <input type="text" name="studentName" size="5" readonly="readonly" style="border: 0px;text-align: center" value="${att.getStudentName() }"></center></td>
                                                                <td class="RULine" nowrap="nowrap" ><center>
                                                                    <input type="text" name="studentName" size="5" readonly="readonly" style="border: 0px;text-align: center;color: red" value="${att.getNowCredits() }"></center></td>
                                                                <td class="RULine" nowrap="nowrap" ><center>
                                                                    <input type="text" name="studentName" size="5" readonly="readonly" style="border: 0px;text-align: center" value="${att.getAimCredits() }"></center></td>
                                                            </tr>
                                                           </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                </tbody>

                                            </table>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                      </section>
                    </div>
                </div>
                <!-- END ROW  -->
            </section>
        </section>
    </form>
    <!-- footer -->
     <%@ include file="publicpage/footer.jsp" %>
     <!--  -->
     

    <!-- END SECTION -->
    <!-- BEGIN JS -->
    <script src="js/jquery.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/message_zn.js"></script>
    <script src="js/bootstrap.min.js"></script><!-- BOOTSTRAP JS -->
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/message_zn.js"></script>
    <script src="js/jquery.dcjqaccordion.2.7.js"></script><!-- ACCORDIN JS -->
    <script src="js/jquery.scrollTo.min.js"></script><!-- SCROLLTO JS -->
    <script src="js/jquery.nicescroll.js"></script><!-- NICESCROLL JS -->
    <script src="js/respond.min.js"></script><!-- RESPOND JS -->
    <script src="js/jquery.sparkline.js"></script><!-- SPARKLINE JS -->
    <script src="js/sparkline-chart.js"></script><!-- SPARKLINE CHART JS -->
    <script src="js/common-scripts.js"></script><!-- BASIC COMMON JS -->
    <script src="js/count.js"></script><!-- COUNT JS -->


    <!-- END JS -->
 </section>

  </body>
</html>
