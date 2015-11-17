<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />


<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<form class="form-horizontal">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-btns">
					<a href="#" class="panel-close">×</a> <a href="#" class="minimize maximize">+</a>
				</div>
				<h3 class="panel-title">搜索条件</h3>
			</div>
			<div class="panel-body search-div" style="display: none; padding: 5px 20px 5px 0px;"></div>
			<div class="panel-footer" style="display: none; padding: 5px;">
				<div class="row">
					<div class="col-sm-7 col-sm-offset-5">
						<button class="btn btn-primary">&nbsp;搜&nbsp;索&nbsp;</button>
						<button type="reset" class="btn btn-default">&nbsp;重&nbsp;置&nbsp;</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<div class="table-responsive">
		<table id="list" class="table table-bordered nowrap" cellspacing="0" width="100%">
		</table>
	</div>
	<!-- table-responsive -->

	<jsp:include page="../import-js.jsp" />
	<script type="text/javascript" src="${basePath }/resources/customer/sys/menu-list.js"></script>

</body>
</html>