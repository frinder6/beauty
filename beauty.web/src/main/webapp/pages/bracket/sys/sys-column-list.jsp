<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
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
					<h3 class="panel-title">未配置列</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table id="l-list" class="table table-bordered" width="100%">
						</table>
					</div>
				</div>
			</div>
			<!-- panel -->
		</div>
		<!-- col-sm-6 -->

		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">已配置列</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table id="r-list" class="table table-bordered" width="100%">
						</table>
					</div>
				</div>
			</div>
			<!-- panel -->
		</div>
		<!-- col-sm-6 -->

	</div>

	<jsp:include page="../import-js.jsp" />
	<script type="text/javascript" src="${basePath }/resources/customer/sys/sys-column-list.js"></script>

	<script type="text/javascript">
		var tableName = '${param.table}';
		var tableSchema = '${param.schema}';
		//
		var conf = function() {
			var url = '/pages/bracket/sys/table-config-list.jsp?table={0}';
			_S_URL_REDIRECT(url.format(tableName))
		};
	</script>

</body>

</html>