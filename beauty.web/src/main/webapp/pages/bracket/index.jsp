<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://frinder.net/taglibs.tld" prefix="my"%>
<html>
<head>
<jsp:include page="import-css.jsp" />
<title>首页</title>
</head>
<body class="leftpanel-collapsed stickyheader" style="overflow: visible;">

	<div id="preloader">
		<div id="status">
			<i class="fa fa-spinner fa-spin"></i>
		</div>
	</div>

	<section>

		<div class="leftpanel sticky-leftpanel">

			<div class="logopanel">
				<h1>
					<span>[</span> 我的后台<span>]</span>
				</h1>
			</div>

			<div id="leftpanelinner" class="leftpanelinner"></div>
		</div>

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
										<li class="new"><a href="">See All Users</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li>
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
									<img src="${basePath }/resources/bracket/images/photos/loggeduser.png" alt="" /> ${SPRING_SECURITY_CONTEXT.authentication.name} <span class="caret"></span>
								</button>
								<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
									<li><a id="user-profile" href="javascript:_REDIRECT('/pages/bracket/user-profile.jsp');"><i class="glyphicon glyphicon-user"></i> 用户信息</a></li>
									<li><a id="cache-flush" href="javascript:void(0)"><i class="glyphicon glyphicon-refresh"></i> 刷新缓存</a></li>
									<li><a href="${basePath}/j_spring_security_logout"><i class="glyphicon glyphicon-log-out"></i> 退出</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>

			</div>

			<div class="pageheader">
				<h2>
					<i class="fa fa-home"></i> 主页
				</h2>
			</div>

			<div class="contentpanel" style="padding: 10px; background-color: #E4E7EA;">
				<iframe id="iframe-main" src="${basePath }/pages/bracket/content.jsp" name="iframe-main" frameborder="0" width="100%" scrolling="no"></iframe>
			</div>

		</div>

	</section>


	<jsp:include page="import-js.jsp" />
	<script src="${basePath }/resources/customer/my.menu.js"></script>
	<script src="${basePath }/resources/customer/my.nav.js"></script>
	<script type="text/javascript">
		$(function() {
			var menu = $('#leftpanelinner').Menu();
			var nav = $('#main-nav').Nav();

			$('#cache-flush').click(function() {
				ajax({
					url : '/redis/flush.action'
				});
			});

			$('#user-profile').click(function() {
				var nav = '\
					<h2>\
						<i class="{0}"></i> {1} <span>{2}</span>\
					</h2>\
				';
				var data = {
					icon : 'fa fa-user',
					title : '用户管理',
					stitle : '用户信息'
				};
				$(window.document).find('div.pageheader').html(nav.format(data.icon, data.title, data.stitle));
			});
		});
	</script>
	<script src="${basePath }/resources/bracket/js/custom.js"></script>
</body>
</html>