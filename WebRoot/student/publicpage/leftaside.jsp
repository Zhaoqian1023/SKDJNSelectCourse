<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a href="index_student.jsp" id="index" class="">
					<i class="fa fa-dashboard"> </i> <span style="font-size: medium">
						<h4>主页</h4>
				</span></a>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-edit"> </i> <span style="font-size: medium">
						选课管理 </span></a>
				<ul class="sub">
					<li><a href="student_getAllCourse?page=checkCourse_student&years=2016-2017/2" id="attendance"
						class=""> 全部课程 </a></li>
					<li><a href="student_allreadyCourse?page=havecheckCourse_student&years=2016-2017/2"
						id="regulargrade" class=""> 已选课程</a></li>
					
				</ul>
			</li>
		</ul>
	</div>
</aside>

