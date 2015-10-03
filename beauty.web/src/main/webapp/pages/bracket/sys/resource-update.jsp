<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app>
<head>
<jsp:include page="../import-css.jsp" />

<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div class="btn-group">
		<a href="javascript:history.back();" class="btn btn-default fa fa-backward">&nbsp;返回</a>
	</div>

	<form id="basicForm" action="${basePath }/resource/update.action" class="form-horizontal" method="post" onsubmit="return false;">
		<input type="hidden" name="id" value="${param.id }" />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">更新资源</h4>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-3 control-label">资源名称： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="name" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">资源编码： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="code" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">资源URL： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="url" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">备注： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<textarea type="textarea" name="remark" rows="5" class="form-control" placeholder="Type please..." required></textarea>
					</div>
				</div>
			</div>
			<!-- panel-body -->
			<div class="panel-footer">
				<div class="row">
					<div class="col-sm-9 col-sm-offset-3">
						<button class="btn btn-primary">提交</button>
						<button type="reset" class="btn btn-default">重置</button>
					</div>
				</div>
			</div>

		</div>
		<!-- panel -->
	</form>


	<%@include file="../import-js.jsp"%>
	<script type="text/javascript">
		var id = '${param.id}';
	</script>
	<script src="${basePath }/resources/customer/sys/resource-update.js"></script>

</body>

</html>