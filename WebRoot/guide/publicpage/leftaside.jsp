<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a href="index_guide.jsp" id="index" class="">
					<i class="fa fa-dashboard"> </i> <span style="font-size: medium">
						<h4>主页</h4>
				</span></a>
			</li>
			<li class="sub-menu"><a href="javascript:;"> 
			<i class="fa fa-print"> </i> <span style="font-size: medium">
						选课情况 </span></a>
				<ul class="sub">
					<li><a href="guide_getUnqualified?className=计算机科学与技术2014-1&years=2016-2017/2&page=unqualifiedStudent_guide" id="attendance"
						class=""> 未达目标学生 </a></li>
					<li><a href="guide_getPeoperNum?years=2016-2017/2&page=rankbyNumber"
						id="regulargrade" class=""> 人数排名 </a></li>
					
				</ul>
			</li>
		</ul>
	</div>
</aside>

