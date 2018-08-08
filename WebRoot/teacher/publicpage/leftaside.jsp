<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a href="index_teacher.jsp" id="index" class="">
					<i class="fa fa-dashboard"> </i> <span style="font-size: medium">
						<h4>主页</h4>
				</span></a>
			</li>
			<li class="sub-menu"><a href="courseadd_teacher.jsp"> <i
					class="fa fa-pencil"> </i> <span style="font-size: medium">
						申请开课 </span></a>
			</li>
			<li class="sub-menu"><a href="teacher_getCourse?page=selectCourse_teacher"> <i
					class="fa fa-edit"> </i> <span style="font-size: medium">
						审核学生信息 </span></a>
			</li>
		</ul>
	</div>
</aside>

