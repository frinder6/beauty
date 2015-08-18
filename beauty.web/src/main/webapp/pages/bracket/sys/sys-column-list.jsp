<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div style="padding: 10px 0 0 20px;">
		<a href="${basePath }/pages/sys/table-config-list.jsp" class="button icon-revert huge">返回</a>
	</div>


	<div class="table-responsive">

		<table id="column-config-list" class="table table-bordered table-hover mb30">
		</table>

	</div>

	<jsp:include page="../import-js.jsp" />

	<script type="text/javascript">
		$(function() {
			init();

			var tools = '<div class="btn-group">\
                <button type="button" class="btn btn-default" onclick="selectAll()">全选</button>\
                <button type="button" class="btn btn-default" onclick="deSelectAll()">取消</button>\
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
				select : {
					style : 'multi'
				}
			});

			// 全选
			selectAll = function() {
				table.rows().select();
			};
			// 取消全选
			deSelectAll = function() {
				table.rows().deselect();
			};

		});
	</script>

</body>

</html>