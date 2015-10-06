<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="import-css.jsp" />
<title>登陆</title>
</head>

<body class="signin">


	<section>

		<div class="signinpanel">

			<div class="row">

				<div class="col-md-7">

					<div class="signin-info">
						<div class="logopanel">
							<h1>
								<span>[</span> 我的后台 <span>]</span>
							</h1>
						</div>
						<!-- logopanel -->

						<div class="mb20"></div>

						<h5>
							<strong>欢迎访问我的后台！</strong>
						</h5>
						<ul>
							<li><i class="fa fa-arrow-circle-o-right mr5"></i> 快捷</li>
							<li><i class="fa fa-arrow-circle-o-right mr5"></i> 安全</li>
							<li><i class="fa fa-arrow-circle-o-right mr5"></i> 稳定</li>
							<li><i class="fa fa-arrow-circle-o-right mr5"></i> 更多...</li>
						</ul>
						<div class="mb20"></div>
					</div>
					<!-- signin0-info -->

				</div>
				<!-- col-sm-7 -->

				<div class="col-md-5">

					<form method="post" action="${basePath}/j_spring_security_check">
						<h4 class="nomargin">登陆</h4>
						<p class="mt5 mb20">请输入您的帐号和密码进入：</p>

						<input type="text" class="form-control uname" name="j_username" placeholder="account" /> 
						<input type="password" class="form-control pword" name="j_password" placeholder="password" /> 
						<a href=""><small>忘记密码？</small></a>
						<button class="btn btn-success btn-block">登陆</button>

					</form>
				</div>
				<!-- col-sm-5 -->

			</div>
			<!-- row -->

		</div>
		<!-- signin -->

	</section>


	<%@include file="import-js.jsp"%>
	<script>
		jQuery(document).ready(function() {

			// Please do not use the code below
			// This is for demo purposes only
			var c = jQuery.cookie('change-skin');
			if (c && c == 'greyjoy') {
				jQuery('.btn-success').addClass('btn-orange').removeClass('btn-success');
			} else if (c && c == 'dodgerblue') {
				jQuery('.btn-success').addClass('btn-primary').removeClass('btn-success');
			} else if (c && c == 'katniss') {
				jQuery('.btn-success').addClass('btn-primary').removeClass('btn-success');
			}
		});
	</script>

</body>
</html>
