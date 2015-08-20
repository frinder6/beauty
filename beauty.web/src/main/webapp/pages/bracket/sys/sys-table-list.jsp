<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">


	<div class="table-responsive">

		<table id="table-config-list" class="table table-bordered mb30">
		</table>

	</div>
	<!-- table-responsive -->

	<%@include file="../import-js.jsp"%>

	<script type="text/javascript">
		var _render = function(data, type, row, meta) {
			var result = '<a href="#" data-href="/pages/bracket/sys/sys-column-list.jsp?schema=beauty&table={0}" onclick="_S_REDIRECT(this)">{1}</a>';
			return result.format(data, data);
		};
		$(function() {
			init();
			
			var tools = '<div class="btn-group">\
                <button type="button" class="btn btn-default" onclick="config()">配置</button>\
            </div>';

			var columnDefs = [ {
				'targets' : 1,
				'render' : _render
			} ];

			var table = $('#table-config-list').datatable({
				tableName : 'TABLES',
				url : '/table/load/schema/tables.action',
				data : {
					tableSchema : 'beauty'
				},
				tools : tools,
				columnDefs : columnDefs
			});

			config = function() {
				var count = table.rows({
					selected : true
				}).count();
				if (count > 0) {
					var items = table.rows({
						selected : true
					}).data();
					var value = items[0].tableName;
					$.ajax({
						"type" : "post",
						"url" : _PATH('/table/config.action'),
						"data" : {
							tableName : value,
							tableSchema : 'beauty'
						},
						"dataType" : 'json',
						"success" : function(data) {
							layer.msg(data.value);
						},
						"error" : function(data) {
							layer.msg(data);
						}
					});
				} else {
					layer.msg('至少选择一条！');
				}
			}

		});
	</script>

</body>

</html>