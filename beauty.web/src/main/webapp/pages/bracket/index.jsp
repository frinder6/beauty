<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://frinder.net/taglibs.tld" prefix="my"%>
<html>
<head>
<jsp:include page="import-css.jsp" />
<link href="${basePath }/resources/bracket/css/jquery.gritter.css" rel="stylesheet">
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
						<li class="top-message">
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
	<script src="${basePath }/resources/bracket/js/jquery.gritter.min.js"></script>
	<script src="${basePath }/resources/customer/my.menu.js"></script>
	<script src="${basePath }/resources/customer/my.nav.js"></script>
	<script src="${basePath }/resources/customer/my.message.js"></script>
	<script type="text/javascript" src="${basePath }/dwr/engine.js"></script>
	<script type="text/javascript" src="${basePath }/dwr/util.js"></script>
	<script type='text/javascript' src='${basePath }/dwr/interface/PushMessageController.js'></script>
	<script type='text/javascript' src="${basePath }/resources/customer/my.server.js"></script>
	<script type="application/javascript">var _userId = '${CURRENT_USER_ACCOUNT}';</script>
	<script src="${basePath }/resources/customer/my.index.js"></script>
	<script src="${basePath }/resources/bracket/js/custom.js"></script>
</body>
</html>