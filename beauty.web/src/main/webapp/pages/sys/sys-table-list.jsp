<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp" flush="true" />

<body style="min-height: 600px;">

	<div class="with-padding">

		<table class="table responsive-table cell-border" id="table-config-list" cellspacing="0" width="100%">
		</table>

	</div>

	<%@include file="../import-js.jsp"%>

	<script type="text/javascript">
		var _render = function(data, type, row, meta) {
			var result = '<a href="#" data-href="/pages/sys/sys-column-list.jsp?schema=beauty&table={0}" onclick="_REDIRECT(this)">{1}</a>';
			return result.format(data, data);
		};
		$(function() {
			init();

			var tools = '<span id="my-tool" class="button-group">\
				<a href="javascript:void(0)" class="button icon-download" onclick="config()">配置</a>\
			</span>';

			var columnDefs = [ {
				'targets' : 0,
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