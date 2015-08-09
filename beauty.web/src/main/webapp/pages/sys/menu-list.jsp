<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp" flush="true" />

<body>

	<div class="with-padding">

		<table class="table responsive-table" id="menu-list" cellspacing="0" width="100%">

			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">菜单编码</th>
					<th scope="col">菜单名称</th>
					<th scope="col">跳转路径</th>
					<th scope="col">备注</th>
					<th scope="col">创建时间</th>
					<th scope="col">修改时间</th>
				</tr>
			</thead>

			<tfoot>
				<tr>
					<td colspan="7"></td>
				</tr>
			</tfoot>

			<tbody>
			</tbody>
		</table>

	</div>

	<%@include file="../import-js.jsp"%>

	<script type="text/javascript">
		$(function() {
			$(window.parent.document).find("#iframe-main").load(function() {
				var main = $(window.parent.document).find("#iframe-main");
				var height = $(window.parent.document).height();
				main.height(height);
			});

			// Table sort - DataTables
			var table = $('#menu-list');
			var url = _PATH('/menu/load/page.action');
			table.DataTable({
				processing : true,
				serverSide : true,
				ajax : url,
				columns : [{
					"data" : 'id',
					"visible": false
				}, {
					"data" : "code"
				}, {
					"data" : "name"
				}, {
					"data" : "url"
				}, {
					"data" : "remark"
				}, {
					"data" : "createTime"
				}, {
					"data" : "lastUpdateTime"
				} ],
				//"dom": '<"toolbar">frtip',
				"language" : {
					"url" : _PATH('/pages/Chinese.json')
				}
			});
			
			var t = $('#menu-list').DataTable();
			
			t.on('order.dt',function(){
				var order = t.order();
				var col = order[0];
				//alert(col);
			});
			
			$('#ck').click(function(){
				var t = $('#menu-list').DataTable();
				var cols = t.columns().flatten();
				alert(cols.length);
				// debugger
				var col = t.column().dataSrc();
				alert(col);
				alert(t.column().index());
			});
		});
	</script>

</body>

</html>