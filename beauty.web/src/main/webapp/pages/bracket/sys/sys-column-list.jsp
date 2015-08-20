<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div class="btn-group">
		<a href="${basePath }/pages/bracket/sys/sys-table-list.jsp" class="btn btn-default fa fa-backward">&nbsp;返回</a>
	</div>

	<div class="table-responsive">

		<table id="column-config-list" class="table table-bordered">
		</table>

	</div>

	<jsp:include page="../import-js.jsp" />

	<script type="text/javascript">
		$(function() {
			init();

			var tools = '<div class="btn-group">\
                <button type="button" class="btn btn-default">导入</button>\
            </div>';

			var table = $('#column-config-list').datatable({
				tableName : 'COLUMNS',
				url : '/table/load/table/columns.action',
				data : {
					tableName : '${param.table}',
					tableSchema : '${param.schema}'
				},
				tools : tools,
				selected : true,
				title : '<input type="checkbox" onclick="checkbox(this)" />',
				select : {
					style : 'multi'
				}
			});
			
			
			// 表格全选方法
			checkbox = function(e){
				var checked = $(e).attr('checked');
				if (checked){
					// 全选
					table.rows().select();
				} else {
					// 取消全选
					table.rows().deselect();
				}
			};

		});
	</script>

</body>

</html>