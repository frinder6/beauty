<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<form id="basicForm" action="${basePath }/menu/add.action" class="form-horizontal">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">新增菜单</h4>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-3 control-label">菜单名称： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="name" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">菜单编码： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="code" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">URL：<span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="url" class="form-control" placeholder="Type please..." required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">父节点：<span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<!-- <select name="parentId" class="select2" data-placeholder="Choose please..." required>
							<option value=""></option>
							<option value="United States">United States</option>
							<option value="United Kingdom">United Kingdom</option>
						</select> -->
						<input id="pselect" name="parentId" class="select2" />
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

	<script type="text/javascript">
		$(function() {
			init();

			$('#pselect').select2({
				width : '100%',
				ajax : {
					url : '${basePath}/menu/select.action',
					dataType : 'json',
					delay : 250,
					data : function(params) {
						return {
							q : params.term
						};
					},
					cache : 'true'
				}
			});
		});
	</script>
</body>

</html>