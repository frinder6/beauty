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

	<form id="basicForm" action="${basePath }/table/add.action" class="form-horizontal" method="post" onsubmit="return false;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">新增配置</h4>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-3 control-label">表格名称： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="tableName" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">列名称： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="title" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">类属性： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="data" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">库列名称： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="columnName" class="form-control" placeholder="Type please..." required />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label">列宽： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="width" class="form-control" placeholder="Type please..." required />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label">样式： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="className" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">备注： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<textarea name="remark" rows="5" class="form-control" placeholder="Type please..." required></textarea>
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
	<script src="${basePath }/resources/customer/sys/table-config-add.js"></script>

</body>

</html>