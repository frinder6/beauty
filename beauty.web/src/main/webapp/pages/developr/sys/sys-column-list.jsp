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
				<a href="javascript:void(0)" class="button icon-new-tab" onclick="selectAll()">全选</a>\
				<a href="javascript:void(0)" class="button icon-reply-all" onclick="deSelectAll()">取消</a>\
				<a href="javascript:void(0)" class="button icon-download">导入</a>\
			</span>';
			
			var table = $('#column-config-list').datatable({
				tableName : 'COLUMNS',
				url : '/table/load/table/columns.action',
				data : {
					tableName : '${param.table}',
					tableSchema : '${param.schema}'
				},
				tools : tools,
				selected : true,
				select : {
					style: 'multi'
				}
			});
			
			// 全选
			selectAll = function(){
				table.rows().select();
			};
			// 取消全选
			deSelectAll = function(){
				table.rows().deselect();
			};
			
		});
	</script>

</body>

</html>