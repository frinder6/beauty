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

	<form id="basicForm" action="${basePath }/queue/add.action" class="form-horizontal" method="post" onsubmit="return false;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">新增队列</h4>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-3 control-label">队列名称： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="queueName" class="form-control" placeholder="Type please..." required ng-model="remark" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">交换区： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="exchangeName" class="form-control" placeholder="Type please..." required  />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">路由规则： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<input type="text" name="routingKey" class="form-control" placeholder="Type please..." required ng-model="remark" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">队列类型： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<select id="pselect" name="type" required placeholder="Type please...">
							<option value="1">DIRECT</option>
							<option value="2" selected="selected">TOPIC</option>
							<option value="3">FANOUT</option>
						</select> <label class="error" for="pselect"></label>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">备注： <span class="asterisk">*</span></label>
					<div class="col-sm-6">
						<textarea name="remark" rows="5" class="form-control" placeholder="Type please..." required>{{remark}}</textarea>
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
		$(function(){

			$('#pselect').select2({
				width : '100%',
				minimumResultsForSearch: Infinity
			});
			
			var form = $('#basicForm').Form({
				listUrl : '/pages/bracket/sys/queue-list.jsp'
			});
		});
	</script>


</body>

</html>