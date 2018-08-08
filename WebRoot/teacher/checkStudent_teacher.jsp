®<%@ page language="java" import="java.util.*"
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
<title>选课情况之人数排名</title>

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
	function checkResult(studentId,courseId,obj){
		if(courseId != "" || studentId != ""){
			var loginInfo = "courseId=" + courseId + "&studentId=" + studentId;
			$.ajax({
				type : "post",
				url : "teacher_deleteSelect.action",
				data : loginInfo,
				async : false,
				success : function(result) {
					eval("var data=" + result);
					if (data.name == "login"
							&& data.descript == "success") {
						$(obj).attr("value", "已驳回");
					} 
				},
				error : function() {
				},
				beforeSend : function(XMLHttpRequest) {
				},
				complete : function(XMLHttpRequest, textStatus) {
				}
	
			});
		}
		
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
									选课人员 </span>
							</header>
							<div id="f1" class="f1">
								<table width="750" cellspacing="0" cellpadding="0" border="0"
									align="center">
									<tbody>
										<tr>
											<td class="Font18" width="50%" valign="middle" align="center"><font
												size="5" face="黑体">选课人员清单</font><br>
											<br></td>
										</tr>
										<tr>
											<td valign="top">
											<center>
												<table  cellspacing="0" cellpadding="0"
													border="0" width="600px">
													<tbody>
														<tr valign="top" align="left">
															<td width="200px">
															
																<table class="LUpLines" width="100%" cellspacing="0"
																	cellpadding="0" border="1" align="center">
																	<tbody>
																		<tr class="Font11PtX120" valign="middle"
																			align="center" style="font-size:18px">
																			<th class="RULine"  nowrap="nowrap" style="text-align:center">序号</th>
																			<th class="RULine" nowrap="nowrap" style="text-align:center">学生学号</th>
																			<th class="RULine"  nowrap="nowrap" style="text-align:center">学生班级</th>
																			<th class="RULine" name="final"  style="text-align:center"
																				nowrap="nowrap">学生姓名</th>
																				<th class="RULine" name="final"  
																				nowrap="nowrap" style="width:70px;text-align:center">操作</th>
																		</tr>
																		<c:forEach items="${studentData }" var="att" varStatus="varstatus">
																		<tr class="Font8Pt" style="height:35px">
																			<td  class="RULine" ><center><input type="text"size="3" name="num" readonly="readonly" style="border: 0px;text-align: center" value="${varstatus.count }"></center></td>
																			<td class="RULine" nowrap="nowrap" ><center>
																				<input type="text" id="studentId" name="studentId" size="20" readonly="readonly" style="border: 0px;text-align:center" value="${att.getsId() }"></center></td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<center>
																				<input type="text" name="teacherName" size="25" readonly="readonly" style="border: 0px;text-align: center" value="${att.getClassName().getcName() }"></center>
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<center>
																				<input type="text" name="selectPeople" size="8" readonly="readonly" style="border: 0px;text-align:center" value="${att.getsName() }"></center>
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center" style="width:20px">
																			<input type="submit" id="delete" value='驳回' onclick="checkResult(${att.getsId() },${courseId},this);" style="width:60px;height:25px">
																			
																		</td>
																		</tr>
																		</c:forEach>
																		<table>
																		<tr style="border: 0px">
																		<td><br><br>&nbsp</td>
																		</tr>
																		</table>
																		
																	</tbody>
																	</center>
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
	<!-- <script type="text/javascript">
	$("#delete").click(
			function() {
				var v1=$("#courseId").val();
				var v2=$("#studentId").val();
				var loginInfo = "courseId=" + v1 + "&studentId=" + v2;
				$.ajax({
					type : "post",
					url : "teacher_deleteSelect.action",
					data : loginInfo,
					async : false,
					success : function(result) {
						eval("var data=" + result);
						if (data.name == "login"
								&& data.descript == "success") {
							$("#delete").attr("value", "已驳回");
						} 
					},
					error : function() {
					},
					beforeSend : function(XMLHttpRequest) {
					},
					complete : function(XMLHttpRequest, textStatus) {
					}

				});
			});
	</script> -->

		
	</section>
</body>
</html>
