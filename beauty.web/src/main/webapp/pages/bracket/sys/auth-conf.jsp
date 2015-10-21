<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<style type="text/css">
div.dataTables_wrapper {
	min-width: 350px;
	max-width: 600px;
	margin: 0 auto;
}
</style>
<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div class="btn-group">
		<a href="javascript:history.back();" class="btn btn-default fa fa-backward">&nbsp;返回</a>
	</div>

	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">未配置项</h3>
				</div>
				<div class="panel-body">
					<table id="l-list" class="table table-bordered" width="100%">
					</table>
				</div>
			</div>
			<!-- panel -->
		</div>
		<!-- col-sm-6 -->

		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<b>[&nbsp;${param.name }&nbsp;]</b>&nbsp;&gt;&gt;&nbsp;已配置项
					</h3>
				</div>
				<div class="panel-body">
					<table id="r-list" class="table table-bordered" width="100%">
					</table>
				</div>
			</div>
			<!-- panel -->
		</div>
		<!-- col-sm-6 -->

	</div>

	<jsp:include page="../import-js.jsp" />

	<script type="text/javascript">
		var authorityId = '${param.id}';
		var type = '${param.type}';
	</script>

	<script type="text/javascript" src="${basePath }/resources/customer/sys/auth-conf.js"></script>
	
</body>

</html>