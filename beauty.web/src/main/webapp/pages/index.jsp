<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://frinder.net/taglibs.tld" prefix="my" %>
<jsp:include page="header.jsp" />
<body class="clearfix with-menu with-shortcuts">

	<!-- Title bar -->
	<header role="banner" id="title-bar">
		<h2>后台管理系统</h2>
	</header>

	<!-- Button to open/hide menu -->
	<a href="#" id="open-menu"><span>Menu</span></a>

	<!-- Button to open/hide shortcuts -->
	<a href="#" id="open-shortcuts"><span class="icon-thumbs"></span></a>
	
	
	<!-- Main content -->
	<section role="main" id="main">
		<iframe src="content.jsp" id="iframe-main" frameborder="0" width="100%" scrolling="no"></iframe>
	</section>
	<!-- End main content -->

	<!-- Side tabs shortcuts -->
	<!-- <ul id="shortcuts" role="complementary" class="children-tooltip tooltip-right">
		<li><a href="./" class="shortcut-dashboard" title="主页">主页</a></li>
		<li class="current"><a href="inbox.html" class="shortcut-messages" title="Messages">Messages</a></li>
		<li><a href="agenda.html" class="shortcut-agenda" title="Agenda">Agenda</a></li>
		<li><a href="tables.html" class="shortcut-contacts" title="Contacts">Contacts</a></li>
		<li><a href="explorer.html" class="shortcut-medias" title="Medias">Medias</a></li>
		<li><a href="sliders.html" class="shortcut-stats" title="Stats">Stats</a></li>
		<li><a href="form.html" class="shortcut-settings" title="Settings">Settings</a></li>
		<li><span class="shortcut-notes" title="Notes">Notes</span></li>
	</ul> -->
	<my:load-main-menu />

	<!-- Sidebar/drop-down menu -->
	<%@include file="left-menu.jsp" %>
	<!-- End sidebar/drop-down menu -->

	<!-- import js file -->
	<%@include file="import-js.jsp" %>
	<!-- import js file -->
	
	<script>

		// Call template init (optional, but faster if called manually)
		$.template.init();
	</script>
</body>
</html>