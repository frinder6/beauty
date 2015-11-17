<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	request.setAttribute("basePath", basePath);
	session.setAttribute("basePath", basePath);
%>
<html>
<head>
<jsp:include page="import-css.jsp" />
<link href="${basePath }/resources/bracket/css/prettyPhoto.css" rel="stylesheet">
<title>内容块</title>
<jsp:include page="import-js.jsp" />
<script src="${basePath }/resources/bracket/js/html5shiv.js"></script>
<script src="${basePath }/resources/bracket/js/respond.min.js"></script>
</head>
<body style="background-color: #E4E7EA;">

	<div class="row">
		<div class="col-sm-3">
			<img src="${basePath }/resources/bracket/images/photos/profile-1.png" class="thumbnail img-responsive" alt="" />

			<div class="mb30"></div>

			<h5 class="subtitle">关于</h5>
			<p class="mb30">
				${CURRENT_USER.user.remark} ... <a href="">更多&gt;&gt;</a>
			</p>

			<h5 class="subtitle">联系</h5>
			<ul class="profile-social-list">
				<li><i class="fa fa-mobile"></i> <a href="">${CURRENT_USER.user.mobile}</a></li>
				<li><i class="fa fa-envelope-square"></i> <a href="">${CURRENT_USER.user.email}</a></li>
			</ul>

			<div class="mb30"></div>

			<h5 class="subtitle">地址</h5>
			<address>
				广东省广州市
			</address>

		</div>
		<!-- col-sm-3 -->
		<div class="col-sm-9">

			<div class="profile-header">
				<h2 class="profile-name">${CURRENT_USER.name}</h2>
				<div class="profile-location">
					<i class="fa fa-mobile"></i> ${CURRENT_USER.user.mobile}
				</div>
				<div class="profile-position">
					<i class="fa fa-envelope-square"></i> ${CURRENT_USER.user.email}
				</div>

				<div class="mb20"></div>

				<button class="btn btn-success mr5">
					<i class="fa fa-user"></i> 关注
				</button>
				<button class="btn btn-white">
					<i class="fa fa-envelope-o"></i> 消息
				</button>
			</div>
			<!-- profile-header -->

			<!-- Nav tabs -->
			<ul class="nav nav-tabs nav-justified nav-profile">
				<li class="active"><a href="#mains" data-toggle="tab"><strong>主要信息</strong></a></li>
				<li><a href="#extras" data-toggle="tab"><strong>额外信息</strong></a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div class="tab-pane active" id="mains">
					AAAAAAAAAAA
				</div>
				<div class="tab-pane" id="extras">
					BBBBBBBBBBB
				</div>
			</div>

		</div>
	</div>


</body>
</html>