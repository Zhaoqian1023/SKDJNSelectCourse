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
<title>详细信息之选择课程</title>

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
									请选择课程 </span>
							</header>
							<div id="f1" class="f1">
								<table width="750" cellspacing="0" cellpadding="0" border="0"
									align="center">
									<tbody>
										<tr>
											<td class="Font18" width="50%" valign="middle" align="center"><font
												size="5" face="黑体">已审核课程清单</font><br>
											<br></td>
										</tr>
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
																		<tr class="Font11PtX120" valign="middle"
																			align="center" style="font-size:18px">
																			<td class="RULine" width="5%" nowrap="nowrap">序号</td>
																			<td class="RULine" width="35%" nowrap="nowrap">课程名</td>
																			<td class="RULine" width="17%" nowrap="nowrap">任课教师</td>
																			<td class="RULine" name="final" width="18%"
																				nowrap="nowrap">学年/学期</td>
																			<td class="RULine" name="final" width="20%"
																				nowrap="nowrap">功能操作</td>
																			<td class="RULine" name="final" width="10%"
																				nowrap="nowrap">状态</td>
																		</tr>
																		<c:forEach items="${courseList }" var="att" varStatus="varstatus">
																		<tr class="Font8Pt"  style="height:30px">
																			<td  class="RULine" ><center><input type="text"size="3" name="num" readonly="readonly" style="border: 0px;text-align: center" value="${varstatus.count }"></center></td>
																			<td class="RULine" nowrap="nowrap" ><center>
																				<input type="text" name="courseName" size="20" readonly="readonly" style="border: 0px" value="${att.getcName() }"></center></td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<center>
																				<input type="text" name="teacherName" size="20" readonly="readonly" style="border: 0px;text-align: center" value="${att.getTeachers().gettName() }"></center>
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<center>
																				<input type="text" name="selectPeople" size="12" readonly="readonly" style="border: 0px;text-align:center" value="${att.getYears() }"></center>
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center" style="text-align:center">
																				
																				<a href="manager_getCourseDetail?courseId=${att.getcId() }&page=courseDetail_manager">查看详情</a>&nbsp;&nbsp;&nbsp;
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<center>
																				<c:if test="${att.getCheckState() == 1 }"><input type="text" name="selectPeople" size="14" readonly="readonly" style="border: 0px;text-align:center" value="通过审核"></c:if>
																				<c:if test="${att.getCheckState() == 0 }"><input type="text" name="selectPeople" size="14" readonly="readonly" style="border: 0px;text-align:center" value="待审核"></c:if>
																				<c:if test="${att.getCheckState() == 2 }"><input type="text" name="selectPeople" size="14" readonly="readonly" style="border: 0px;text-align:center" value="审核未通过"></c:if>
																				
																				</center>
																			</td>
																		</tr>
																		</c:forEach>
																		<table>
																		<tr style="border: 0px">
																		<td><br><br>&nbsp</td>
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
