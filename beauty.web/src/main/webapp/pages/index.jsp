<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://frinder.net/taglibs.tld" prefix="my" %>
<jsp:include page="header.jsp" />
<body class="clearfix with-menu with-shortcuts">

	<!-- Title bar -->
	<header role="banner" id="title-bar" style="height: 5px">
		<!-- <h2>后台管理系统</h2> -->
	</header>

	<!-- Button to open/hide menu -->
	<a href="#" id="open-menu"><span>Menu</span></a>
	<!-- Button to open/hide shortcuts -->
	<a href="#" id="open-shortcuts"><span class="icon-thumbs"></span></a>
	<!-- Button to open/hide menu -->
	
	<!-- Main content -->
	<section role="main" id="main" style="min-height: 700px;">
		<iframe src="${basePath }/pages/content.jsp" id="iframe-main" name="iframe-main" frameborder="0" width="100%" scrolling="no"></iframe>
	</section>
	<!-- End main content -->

	<!-- Side tabs shortcuts -->
	<my:load-main-menu />
	<!-- Side tabs shortcuts -->

	<!-- Sidebar/drop-down menu -->
	<section id="menu" role="complementary" style="margin-top: -30px;">
		<!-- <header> 当前用户</header> -->
		<!-- This wrapper is used by several responsive layouts -->
		<div id="menu-content">
	
			<div id="profile">
				<img src="${basePath}/resources/developr/img/user.png" width="64" height="64" alt="User name" class="user-icon">
				你好：
				<span class="name">John <b>Doe</b>&nbsp;&nbsp;<a style="font-size: 12px;" href="#">[注销]</a></span>
			</div>
	
			<!-- By default, this section is made for 4 icons, see the doc to learn how to change this, in "basic markup explained" -->
			<ul id="access" class="children-tooltip">
				<li><a href="inbox.html" title="Messages"><span class="icon-inbox"></span><span class="count">2</span></a></li>
				<li><a href="calendars.html" title="Calendar"><span class="icon-calendar"></span></a></li>
				<li><a href="login.html" title="Profile"><span class="icon-user"></span></a></li>
				<li><a href="setting.html" title="Setting"><span class="icon-gear"></span></a></li>
			</ul>
			
			<section class="navigable"></section>
			
		</div>
		
		<!-- This is optional -->
		<footer id="menu-footer" style="position: absolute;bottom: 0px;width: 90%;">
			<p class="button-height">
				<input type="checkbox" name="auto-refresh" id="auto-refresh" checked="checked" class="switch float-right" title="自动刷新" />
				<!-- <label for="auto-refresh">自动刷新</label> -->
			</p>
		</footer>
		
		<!-- End content wrapper -->
	</section>
	<!-- End sidebar/drop-down menu -->

	<!-- import js file -->
	<%@include file="import-js.jsp" %>
	<!-- import js file -->
	<script src="${basePath}/resources/customer/index.js"></script>
</body>
</html>