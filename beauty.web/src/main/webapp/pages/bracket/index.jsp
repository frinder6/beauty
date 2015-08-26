<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://frinder.net/taglibs.tld" prefix="my"%>
<html>
<head>
<jsp:include page="import-css.jsp" />
<title>首页</title>
</head>
<body class="leftpanel-collapsed stickyheader">

	<!-- Preloader -->
	<div id="preloader">
		<div id="status">
			<i class="fa fa-spinner fa-spin"></i>
		</div>
	</div>

	<section>

		<div class="leftpanel sticky-leftpanel">

			<div class="logopanel">
				<h1>
					<span>[</span> 我的后台 <span>]</span>
				</h1>
			</div>
			<!-- logopanel -->

			<div class="leftpanelinner">
				<h5 class="sidebartitle">导航栏</h5>
				<my:load-main-menu />
			</div>
			<!-- leftpanelinner -->
		</div>
		<!-- leftpanel -->

		<div class="mainpanel">

			<div class="headerbar">

				<!-- 折叠按钮 -->
				<a class="menutoggle"><i class="fa fa-bars"></i></a>

				<div class="header-right">
					<ul class="headermenu">
						<li>
							<div class="btn-group">
								<button class="btn btn-default dropdown-toggle tp-icon" data-toggle="dropdown">
									<i class="glyphicon glyphicon-user"></i> <span class="badge">2</span>
								</button>
								<div class="dropdown-menu dropdown-menu-head pull-right">
									<h5 class="title">2 Newly Registered Users</h5>
									<ul class="dropdown-list user-list">
										<li class="new">
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user1.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Draniem Daamul (@draniem)</a> <span class="badge badge-success">new</span>
												</h5>
											</div>
										</li>
										<li class="new">
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user2.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Zaham Sindilmaca (@zaham)</a> <span class="badge badge-success">new</span>
												</h5>
											</div>
										</li>
										<li>
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user3.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Weno Carasbong (@wenocar)</a>
												</h5>
											</div>
										</li>
										<li>
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user4.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Nusja Nawancali (@nusja)</a>
												</h5>
											</div>
										</li>
										<li>
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user5.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Lane Kitmari (@lane_kitmare)</a>
												</h5>
											</div>
										</li>
										<li class="new"><a href="">See All Users</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li>
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
									<img src="${basePath }/resources/bracket/images/photos/loggeduser.png" alt="" /> John Doe <span class="caret"></span>
								</button>
								<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
									<li><a href="profile.html"><i class="glyphicon glyphicon-user"></i> My Profile</a></li>
									<li><a href="#"><i class="glyphicon glyphicon-cog"></i> Account Settings</a></li>
									<li><a href="#"><i class="glyphicon glyphicon-question-sign"></i> Help</a></li>
									<li><a href="signin.html"><i class="glyphicon glyphicon-log-out"></i> Log Out</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<!-- header-right -->

			</div>
			<!-- headerbar -->

			<!-- <div class="pageheader">
				<h2>
					<i class="fa fa-home"></i> Dashboard <span>Subtitle goes here...</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">You are here:</span>
					<ol class="breadcrumb">
						<li><a href="index.html">Bracket</a></li>
						<li class="active">Dashboard</li>
					</ol>
				</div>
			</div> -->

			<div class="contentpanel" style="padding: 10px;background-color: #E4E7EA;">
					
				<!-- table-responsive -->
				<iframe id="iframe-main" src="${basePath }/pages/bracket/content.jsp" name="iframe-main" frameborder="0" width="100%" scrolling="no"></iframe>

			</div>
			<!-- contentpanel -->

		</div>
		<!-- mainpanel -->


	</section>


	<jsp:include page="import-js.jsp" />
	
	<script type="text/javascript">
		$(function(){
			$('#main-nav').children('li').click(function() {
				// 二级菜单样式
				$('#main-nav').children('li').removeClass('active');
				$(this).addClass('active');
			});
			
			$('#main-nav').find('ul').find('li').click(function(){
				var url = $(this).children('a').attr('data-href');
				_REDIRECT(url);
			});
			
		});
	</script>
</body>
</html>