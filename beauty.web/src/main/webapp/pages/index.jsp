<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://frinder.net/taglibs.tld" prefix="my" %>
<jsp:include page="header.jsp" />
<body class="clearfix with-menu with-shortcuts" style="overflow: hidden;">

	<!-- Title bar -->
	<header role="banner" id="title-bar">
		<h2>后台管理系统</h2>
	</header>

	<!-- Button to open/hide menu -->
	<a href="#" id="open-menu"><span>Menu</span></a>
	<!-- Button to open/hide shortcuts -->
	<a href="#" id="open-shortcuts"><span class="icon-thumbs"></span></a>
	<!-- Button to open/hide menu -->
	
	
	<!-- Main content -->
	<section role="main" id="main" class="scrollable" style="height: 642px;">
		<iframe src="content.jsp" id="iframe-main" frameborder="0" width="100%" scrolling="no"></iframe>
	</section>
	<!-- End main content -->

	<!-- Side tabs shortcuts -->
	<my:load-main-menu />
	<!-- Side tabs shortcuts -->

	<!-- Sidebar/drop-down menu -->
	<section id="menu" role="complementary">
		<header>
			当前用户
		</header>
		<iframe src="left-menu.jsp?id=1" id="iframe-left-menu" frameborder="0" width="100%" scrolling="no"></iframe>
	</section>
	<!-- End sidebar/drop-down menu -->

	<!-- import js file -->
	<%@include file="import-js.jsp" %>
	<!-- import js file -->
	
	<script>
		// Call template init (optional, but faster if called manually)
		$.template.init();
		
		
		$(function(){
			
			// 切换菜单
			$('#shortcuts').find('li').click(function(){
				$('#shortcuts').find('li').removeClass('current');
				$(this).addClass('current');
				var url = "left-menu.jsp?url={0}";
				var param = $(this).attr('data-href');
				$('#iframe-left-menu').attr("src", url.format(param));
			});
		});
	</script>
</body>
</html>