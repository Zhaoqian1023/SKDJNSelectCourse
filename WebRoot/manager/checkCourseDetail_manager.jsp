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
<title>审核选课之课程详情</title>

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
											<!-- <tr>
											<td class="Font18" width="50%" valign="middle" align="center"><font
												size="5" face="黑体">选课人数排名清单</font><br>
											<br></td>
										</tr> -->
											<tr>
												<td valign="top">
													<table width="100%" cellspacing="0" cellpadding="0"
														border="0">
														<tbody>
															<tr valign="top" align="left">
																<td width="200px">
																	<table class="LUpLines" width="100%" cellspacing="0"
																		cellpadding="0" border="1" align="left">
																		<tbody>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">课程名称</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="courseName" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getcName() }">
																					</center></td>

																			</tr>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">课程代码</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="courseNo" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getcNo() }">
																					</center></td>

																			</tr>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">任课教师</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="teacherName" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getTeachers().gettName() }">
																					</center></td>

																			</tr>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">课程类别</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="category" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getCategory() }">
																					</center></td>

																			</tr>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">学分</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="credits" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getCredits() }">
																					</center></td>

																			</tr>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">总学时</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="times" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getTime() }">
																					</center></td>

																			</tr>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">上课时间</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="schoolTime" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getSchoolTime() }">
																					</center></td>

																			</tr>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">学年/学期</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="years" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getYears() }">
																					</center></td>

																			</tr>
																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">限报人数（上限）</td>
																				<td class="RULine" nowrap="nowrap"><center>
																						<input type="text" name="maxCount" size="20"
																							readonly="readonly"
																							style="border: 0px; text-align: center"
																							value="${course.getMaxCount() }">
																					</center></td>

																			</tr>
																			<tr class="Font11PtX120" valign="middle"
																				align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">开放班级</td>
																				<td class="RULine">
																					<center>
																						<c:forEach items="${course.getOpenClass() }"
																							var="att">
																							<input type="text" size="25" name="openClass"
																								readonly="readonly"
																								style="border: 0px;text-align: center"
																								value="${att.getcName() }">
																							</br>
																						</c:forEach>
																					</center>
																				</td>
																			</tr>

																			<tr class="Font8Pt" valign="middle" align="center">
																				<td class="RULine" width="30%" nowrap="nowrap">课程简介</td>
																				<td class="RULine" nowrap="nowrap">
																				${course.getDetails() }
																						
																					</td>

																			</tr>
																			<table>
																				<tr style="border: 0px">
																				    <td>
																				    	<button class="btn btn-primary" type="button"><a href="manager_getCheckCourse?years=2016-2017/2&page=checkCourse_manager">返回</a></button>
																					</td>
																					<td><br>
																					<br>&nbsp</td>
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
