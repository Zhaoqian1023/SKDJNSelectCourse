<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--xmlns="http://www.w3.org/1999/html"  -->
<html lang="zh" >
<head>
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Olive Enterprise">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<!-- END META -->

<!-- BEGIN SHORTCUT ICON -->
<!--<link rel="shortcut icon" href="img/favicon.ico">-->
<!-- END SHORTCUT ICON -->
<title>课程详情</title>

<!-- BEGIN STYLESHEET -->
<link rel="stylesheet" href="css/main.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- FONT AWESOME ICON STYLESHEET -->
<link href="assets/jquery-ui/jquery-ui-1.10.1.custom.min.css"
	rel="stylesheet">
<!-- JQUERY STYLESHEET -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/style-responsive.css" rel="stylesheet">
<!-- THEME BASIC RESPONSIVE  CSS -->
<script type="text/javascript">
	function active() {
		$("#rankbyNumber").attr("class", "active");
	}
</script>
<!-- END STYLESHEET-->
</head>
<body >
	<section id="container" class="">
    <!--header-->
     <%@ include file="publicpage/head.jsp" %>
    <!---->
        
      <!-- aside -->
      <%@ include file="publicpage/leftaside.jsp" %>
      <!---->
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
									课程详情 </span>
							</header>
							<div id="f1" class="f1">
								<table width="750" cellspacing="0" cellpadding="0" border="0"
									align="center">
									<tbody>
										<tr>
											<td class="Font18" width="50%" valign="middle" align="center"><font
												size="5" face="黑体">选课人员</font><br>
											<br></td>
										</tr>
										<tr>
											<td>
												<table class="Font11PtX120" width="100%" cellspacing="0"
													cellpadding="0" border="0" align="center">
													<tbody>
														<tr valign="middle" align="left">
															<td height="24" width="40%" nowrap="nowrap" align="left">课程名：<input type="text" name="courseName" readonly="readonly" style="border: 0px; width:200px" value="${course.getcName() }"></td>
															<td height="24" nowrap="nowrap" align="left" name="a2">任课教师：<input type="text" name="courseId" readonly="readonly" style="border: 0px" value="${course.getTeachers().gettName() }"></td>
															<td height="24" width="40%" nowrap="nowrap" align="left">学期学年：<input type="text" name="year" readonly="readonly" style="border: 0px" value="${course.getYears() }"></td>
															<td>&nbsp;</td>
														</tr>
														<tr valign="middle" align="left">
															<td height="24" nowrap="nowrap" align="left">学分：<input type="text" name="credits" readonly="readonly" style="border: 0px; " value="${course.getCredits() }"></td>
															<td height="24" nowrap="nowrap" align="left">总学时：<input type="text" name="time" readonly="readonly" style="border: 0px" value="${course.getTime() }"></td>
															<td height="24" nowrap="nowrap" align="left">课程类别：<input type="text" name="category" readonly="readonly" style="border: 0px" value="${course.getCategory() }"></td>
															<td height="24" nowrap="nowrap" align="left">上课时间：<input type="text" name="schoolTime" readonly="readonly" style="border: 0px" value="${course.getSchoolTime() }"></td>
														</tr>
														</tbody>
										<tr>
											<td valign="top" colspan="4">
												<table width="100%" cellspacing="0" cellpadding="0"
													border="0" >
													<tbody>
														<tr valign="top" align="left">
															<td width="200px">
																<table class="LUpLines" width="100%" cellspacing="0"
																	cellpadding="0" border="1" align="left">
																	<tbody>
																		<tr class="Font11PtX120" valign="middle"
																			align="center" style="font-size:16px">
																			<td class="RULine" width="15%" nowrap="nowrap">序号</td>
																			<td class="RULine" width="30%" nowrap="nowrap">学号</td>
																			<td class="RULine" width="20%" nowrap="nowrap">学生姓名</td>
																			<td class="RULine" width="35%" nowrap="nowrap">班级</td>
																		</tr>
																		<c:forEach items="${studentList }" var="att" varStatus="varstatus">
																		<tr class="Font8Pt" valign="top" >
																			<td  class="RULine" ><center><input type="text"size="3" name="num" readonly="readonly" style="border: 0px;text-align: center" value="${varstatus.count }"></center></td>
																			<td class="RULine" nowrap="nowrap" ><center>
																				<input type="text" name="courseName" size="20" readonly="readonly" style="border: 0px;text-align: center" value="${att.getsId() }" ></center></td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<center>
																				<input type="text" name="teacherName" size="10" readonly="readonly" style="border: 0px;text-align: center" value="${att.getsName() }"></center>
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<center>
																				<input type="text" name="selectPeople" size="40" readonly="readonly" style="border: 0px;text-align:center" value="${att.getClassName().getcName() }"></center>
																			</td>
																		</tr>
																		</c:forEach>
																		<table>
																		<tr style="border: 0px">
																		<td><br><br>&nbsp;</td>
																		</tr>
																		</table>
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
			</form>
			<!-- END WRAPPER  -->

			<!-- END MAIN CONTENT -->
			<!-- START FOOTER -->
			<%@ include file="publicpage/footer.jsp"%>
			<!-- END FOOTER -->
		</section>
		<!-- START JS -->
		 <script src="js/jquery.js"></script>
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


		
	</section>
</body>
</html>
