<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp" flush="true" />

<body style="min-height: 600px;">

	<div style="padding: 10px 0 0 20px;">
		<a href="${basePath }/pages/sys/table-config-list.jsp" class="button icon-revert huge">返回</a>
	</div>

	<div class="with-padding">
		
		<table class="table responsive-table cell-border" id="column-config-list" cellspacing="0" width="100%">
		</table>

	</div>

	<%@include file="../import-js.jsp"%>

	<script type="text/javascript">
		$(function() {
			init();

			var tools = '<span id="my-tool" class="button-group">\
				<a href="javascript:void(0)" class="button icon-star">Create</a>\
				<a href="javascript:void(0)" class="button icon-download">Save</a>\
				<a href="javascript:void(0)" class="button icon-new-tab">Duplicate</a>\
				<a href="javascript:void(0)" class="button icon-trash">Delete</a>\
			</span>';

			$('#column-config-list').datatable({
				tableName : 'TB_COLUMN_CONFIG',
				url : '/table/load/table/columns.action',
				data : {
					tableName : '${param.table}',
					tableSchema : '${param.schema}'
				},
				tools : tools
			});

		});
	</script>

</body>

</html>