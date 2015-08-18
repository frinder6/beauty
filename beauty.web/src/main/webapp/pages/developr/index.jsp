<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://frinder.net/taglibs.tld" prefix="my"%>
<jsp:include page="header.jsp" />
<body class="clearfix with-menu with-shortcuts menu-hidden">

	<!-- Title bar -->
	<header role="banner" id="title-bar">

	</header>

	<!-- Button to open/hide menu -->
	<a href="#" id="open-menu"><span>Menu</span></a>

	<!-- Main content -->
	<section role="main" id="main" style="min-height: 700px;">
		<iframe src="${basePath }/pages/content.jsp" id="iframe-main" name="iframe-main" frameborder="0" width="100%" scrolling="no"></iframe>
	</section>
	<!-- End main content -->

	<!-- Side tabs shortcuts -->
	<my:load-main-menu />
	<!-- Side tabs shortcuts -->

	<!-- Sidebar/drop-down menu -->
	<section id="menu" role="complementary" style="height: 150px;margin-top: -1px;">
		<header> 当前用户</header>
		<!-- This wrapper is used by several responsive layouts -->
		<div id="menu-content">

			<div id="profile">
				<img src="${basePath}/resources/developr/img/user.png" width="64" height="64" alt="User name" class="user-icon"> 你好： <span class="name">John <b>Doe</b> <br /> <a style="font-size: 12px;" href="#">[注销]</a></span>
			</div>

		</div>

		<!-- End content wrapper -->
	</section>
	<!-- End sidebar/drop-down menu -->
	
	<button id="default-click" style="display: none;"></button>

	<!-- import js file -->
	<%@include file="import-js.jsp"%>
	<!-- import js file -->
	<script src="${basePath}/resources/customer/index.js"></script>
	<script type="text/javascript">
		$(function() {
		});
	</script>
</body>
</html>