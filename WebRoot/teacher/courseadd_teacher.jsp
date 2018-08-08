<%@ page language="java" import="java.util.* ,com.po.Student"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Olive Enterprise">

<title>申请开课</title>

<!-- BEGIN STYLESHEET -->

<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- FONT AWESOME ICON CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/style-responsive.css" rel="stylesheet">
<!-- THEME RESPONSIVE CSS -->
<link href="assets/morris.js-0.4.3/morris.css" rel="stylesheet">
<!-- MORRIS CHART CSS -->
<!--dashboard calendar-->
<link href="css/clndr.css" rel="stylesheet">
<script type="text/javascript">
	function active() {
		$("#scoreinput").attr("class", "active");
	}
	function checkAction(n){
		if(n == 0){
			document.formName.action="teacher_applicationCourse";
			dbform.submit();
		}
	}
</script>
<script type="text/javascript"> 

	function checkAll(name) {
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == name)) {
				el[i].checked = true;
			}
		}
	}
	function clearAll(name) {
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == name)) {
				el[i].checked = false;
			}
		}
	}
</script> 
</head>

<body onload="active(),setup()">
	<section id="container" class="">
		<!-- BEGIN HEADER -->
		<%@ include file="publicpage/head.jsp"%>
		<!-- END HEADER -->

		<!-- BEGIN SIDEBAR -->
		<%@ include file="publicpage/leftaside.jsp"%>
		<!-- END SIDEBAR -->

		<!-- START MAIN CONTENT -->
		<section id="main-content">
			<!-- START WRAPPER -->
			<section class="wrapper">

				<!-- START ROW -->
				<section class="panel">
					<header class="panel-heading">
						<i class="fa fa-hand-o-down"> </i> <span
							class="label label-primary" style="font-size:medium"> 申请开课
						</span>
					</header>
					<div class="panel-body">
						<form name="formName" method="post" action="" >
							<div class="modal-dialog">
								<div class="modal-content">

									<div class="modal-body" style="padding: 100px 100px 10px;">
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												课程名&nbsp;:&nbsp;&nbsp;&nbsp;</label> 
												<input name="courseName" type="text" style="width:200px;">
										</div>
										<div>
										<label for="name" style="font-size: medium" > 任课教师:&nbsp; </label>
										 <input
												name="teacherName" readonly="readonly" type="text" value="${teacher.gettName() }(${teacher.gettId() })" style="width:200px;">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												学&nbsp;&nbsp;&nbsp;分&nbsp;:&nbsp;&nbsp;&nbsp;</label> 
												<!-- <input name="credits" type="text" style="width:200px;"> -->
												<select
												name="credits" style="width:200px;">

												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												</select>
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												总学时&nbsp;:&nbsp;&nbsp;&nbsp;</label> 
												<!-- <input name="time" type="text" style="width:200px;"> -->
												<select
												name="time" style="width:200px;">

												<option value="36">36</option>
												<option value="48">48</option>
												</select>
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium" > 学年学期:&nbsp; </label> 
												<select
												name="years" style="width:200px;">

												<option value="2016-2017/2">2016-2017/2</option>
												<option value="2017-2018/1">2017-2018/1</option>
												</select>
										</div><div width="100px" height="20px">
											<label for="name" style="font-size: medium" > 最大人数:&nbsp; </label> <input
												name="maxCount" type="text" style="width:200px;">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												课程类型:&nbsp;&nbsp;</label><input name="category" type="radio" value="公选"
												checked />公选 </label>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>
												<input name="category" type="radio"
												value="系选" /> 系选</label>
										</div>
						
										<label for="name" style="font-size: medium;">
												课程简介:&nbsp;</label>
										<div width="100px" height="20px">
											 <textarea name="details" style="width:280px;" rows="4" placeholder="请输入对本课程的介绍"></textarea>
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												开放班级:&nbsp;
												<input type="button" value="全选" onclick="checkAll('openClass')" /> 
												<input type="button" value="全不选" onclick="clearAll('openClass')" />  
												</label> <br>
												<table style="border:1px">
												<tr>
	                    						<td width="50%"><input type="checkbox" name="openClass" value="142041"/> 计算机科学与技术2014-1 &nbsp;&nbsp;</td>
	                    						<td width="50%"><input type="checkbox" name="openClass" value="141041"/>  会计学2014-1 &nbsp;</td>
	                    						</tr>
	                    						<tr>
	                    						<td><input type="checkbox" name="openClass" value="142042"> 计算机科学与技术2014-2 &nbsp;</td>
	                    						<td><input type="checkbox" name="openClass" value="141042"> 会计学2014-2 &nbsp;</td>
	                    						</tr>
	                    						<tr> 
	                    						<td><input type="checkbox" name="openClass" value="142043"> 计算机科学与技术2014-3 &nbsp;</td>
	                    						<td><input type="checkbox" name="openClass" value="141043"> 会计学2014-3 &nbsp;</td>
	                    						</tr>
	                    						<tr>
	                    						<td><input type="checkbox" name="openClass" value="142011"> 电气工程及其自动化2014-1 &nbsp;</td>
	                    						<td><input type="checkbox" name="openClass" value="141044"> 会计学2014-4 &nbsp;</td>
	                    						</tr>
	                    						<tr>
	                    						<td><input type="checkbox" name="openClass" value="142012"> 电气工程及其自动化2014-2 &nbsp;</td>
	                    						<td><input type="checkbox" name="openClass" value="141031"> 金融学2014-1 &nbsp;</td>
	                    						</tr>
	                    						<tr>
	                    						<td><input type="checkbox" name="openClass" value="142013"> 电气工程及其自动化2014-3 &nbsp;</td>
	                    						<td><input type="checkbox" name="openClass" value="141032"> 金融学2014-2 &nbsp;</td>
	                    						</tr>
	                    						<tr>
	                    						<td><input type="checkbox" name="openClass" value="142021"> 信息管理与信息系统2014-1 &nbsp;</td>
	                    						<td><input type="checkbox" name="openClass" value="141033"> 金融学2014-3 &nbsp;</td>
	                    						</tr>
	                    						</table>
	                    						
										</div>
										


										<div class="modal-footer">
										<button class="btn btn-primary" data-toggle="modal"
													data-toggle="modal" data-target="#mymodaltwo"
													type="button">提交申请</button>
													<h5>
													<br>
												</h5>
										</div>
									</div>
									
									<div class="modal fade" id="mymodaltwo" style="margin-bottom: 20px">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">提交申请</h4>
										</div>
										<div class="modal-body" style="padding: 100px 100px 10px;">
											<div class="text-danger"
												style="font-size: medium;margin: auto">请仔细检查填写信息是否有误，确定没有问题后请点击确认提交，此申请将传给教务管理员进行审核。</div>
										</div>
										<div class="modal-footer">
											<button class="btn btn-success" type="submit" onclick="checkAction(0);">确认提交</button>
										</div>
									</div>
								</div>
							</div>

								</div>
							</div>
						</form>
				</section>

				<br> <br> <br>
				</div>
				<!-- START WRAPPER -->
			</section>
			<!-- END MAIN CONTENT -->

			<!-- START FOOTER -->
			<%@ include file="publicpage/footer.jsp"%>
			<!-- END FOOTER -->
		</section>
		<!-- START JS -->
		<script src="js/jquery-1.8.3.min.js"></script>
		<!-- BASIC JQUERY 1.8.3 LIB. JS -->
		<script src="js/bootstrap.min.js"></script>
		<!-- BOOTSTRAP JS -->
		<script src="js/jquery.dcjqaccordion.2.7.js"></script>
		<!-- ACCORDIN JS -->
		<script src="js/jquery.scrollTo.min.js"></script>
		<!-- SCROLLTO JS -->
		<script src="js/jquery.nicescroll.js"></script>
		<!-- NICESCROLL JS -->
		<script src="js/respond.min.js"></script>
		<!-- RESPOND JS -->
		<script src="js/jquery.sparkline.js"></script>
		<!-- SPARKLINE JS -->
		<script src="js/sparkline-chart.js"></script>
		<!-- SPARKLINE CHART JS -->
		<script src="js/common-scripts.js"></script>
		<!-- BASIC COMMON JS -->
		<script src="js/count.js"></script>
		<!-- COUNT JS -->
		<!--Morris-->
		<script src="assets/morris.js-0.4.3/morris.min.js"></script>
		<!-- MORRIS JS -->
		<script src="assets/morris.js-0.4.3/raphael-min.js"></script>
		<!-- MORRIS  JS -->
		<script src="js/chart.js"></script>
		<!-- CHART JS -->
		<!--Calendar-->
		<script src="js/calendar/clndr.js"></script>
		<!-- CALENDER JS -->
		<script src="js/calendar/evnt.calendar.init.js"></script>
		<!-- CALENDER EVENT JS -->
		<script src="js/calendar/moment-2.2.1.js"></script>
		<!-- CALENDER MOMENT JS -->
		<!--<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>&lt;!&ndash; UNDERSCORE JS &ndash;&gt;-->
		<script src="assets/jquery-knob/js/jquery.knob.js"></script>
		<!-- JQUERY KNOB JS -->
		<script>
			//knob
			$(".knob").knob();
			
		</script>

		<!-- END JS -->
	</section>
</body>
</html>