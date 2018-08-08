<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a href="index_manager.jsp" id="index" class=""> <i
					class="fa fa-dashboard"> </i> <span style="font-size: medium">
						<h4>主页</h4>
				</span></a></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-edit"> </i> <span style="font-size: medium">
						教师管理 </span></a>
				<ul class="sub">
					<li><a href="teacheradd_manager.jsp" id="attendance" class="">
							新增教师 </a></li>
					<li><a href="teacherfind_manager.jsp" id="regulargrade"
						class=""> 信息修改 </a></li>
					<li><a href="creatpwd_manager.jsp" id="attendance" class="">
							生成密码 </a></li>
				</ul></li>
			<!-- <li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-edit"> </i> <span style="font-size: medium">
						用户管理 </span></a>
				<ul class="sub">

					<li><a href="useradd_manager.jsp" id="attendance"
						class="">新增用户</a></li>
					<li><a href="userdelete_manager.jsp"
						id="regulargrade" class=""> 删除用户 </a></li>
				</ul></li> -->
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-edit"> </i> <span style="font-size: medium">
						学生管理 </span></a>
				<ul class="sub">
					<li><a href="studentadd_manager.jsp" id="attendance" class="">
							添加学生 </a></li>
					<li><a href="studentfind_manager.jsp" id="regulargrade"
						class=""> 信息修改 </a></li>
				</ul>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-edit"> </i> <span style="font-size: medium">
						选课管理 </span></a>
				<ul class="sub">
					<li><a
						href="manager_getCheckCourse?years=2016-2017/2&page=checkCourse_manager"
						id="attendance" class=""> 审核信息 </a></li>
					<li><a
						href="manager_getPeoperNum?years=2016-2017/2&page=rankbyNumber"
						id="regulargrade" class=""> 人数排名 </a></li>
					<li><a
						href="manager_getAllCourse?years=2016-2017/2&page=selectCourse_manager"
						id="regulargrade" class=""> 课程详情 </a></li>
				</ul></li>
		</ul>
	</div>
</aside>

