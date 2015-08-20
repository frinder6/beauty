<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />


<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div class="table-responsive">

		<table id="menu-list" class="table table-bordered">
		</table>

	</div>
	<!-- table-responsive -->

	<jsp:include page="../import-js.jsp" />
	
	<script type="text/javascript">
		$(function(){
			init();
			
			var tools = '<div class="btn-group">\
                <button type="button" class="btn btn-default">新增</button>\
                <button type="button" class="btn btn-default">更新</button>\
                <button type="button" class="btn btn-default">删除</button>\
            </div>';
			
						
			var table = $('#menu-list').datatable({
				tableName : 'BEAUTY_MENU',
				url : '/menu/load/page.action',
				tools : tools,
				selected : true,
				title : '<input type="checkbox" onclick="checkbox(this)" />',
				select : {
					style: 'multi'
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