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
			var result = '<a href="#" data-href="/pages/sys/column-config-list.jsp?schema=beauty&table={0}" onclick="_REDIRECT(this)">{1}</a>';
			return result.format(data, data);
		};
		$(function() {
			init();

			var tools = '<div class="btn-group">\
                <button type="button" class="btn btn-default">保存</button>\
            </div>';

			var columnDefs = [ {
				'targets' : 1,
				'render' : _render
			} ];

			var table = $('#table-config-list').datatable({
				tableName : 'BEAUTY_TABLE_CONFIG',
				url : '/table/load/config.action',
				tools : tools,
				columnDefs : columnDefs,
				fnRowCallback : function(nRow, aData, iDisplayIndex) {
					$('td:eq(2)', nRow).editable({
			           // mode: 'inline'
			        });
				    return nRow;
				}
			});

		});
	</script>

</body>

</html>