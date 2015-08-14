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
			var result = '<a href="#" data-href="/pages/sys/column-config-list.jsp?schema=beauty&table={0}" onclick="_REDIRECT(this)">{1}</a>';
			return result.format(data, data);
		};
		$(function() {
			init();

			var tools = '<span id="my-tool" class="button-group">\
				<a href="javascript:void(0)" class="button icon-star">Create</a>\
				<a href="javascript:void(0)" class="button icon-download">Save</a>\
				<a href="javascript:void(0)" class="button icon-new-tab">Duplicate</a>\
				<a href="javascript:void(0)" class="button icon-trash">Delete</a>\
			</span>';

			var columnDefs = [{
				'targets' : 0,
				'render' : _render
			}];

			$('#table-config-list').datatable({
				tableName : 'TB_TABLE_CONFIG',
				url : '/table/load/schema/tables.action',
				data : {
					tableSchema : 'beauty'
				},
				tools : tools,
				columnDefs : columnDefs
			}); 


		});
	</script>

</body>

</html>