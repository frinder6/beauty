<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp" flush="true" />

<body>

	<div class="with-padding">
		
		<table class="table responsive-table cell-border" id="menu-list" cellspacing="0" width="100%">
		</table>

	</div>

	<%@include file="../import-js.jsp"%>
	<script type="text/javascript" src="${basePath }/resources/customer/jquery-datatables.js"></script>

	<script type="text/javascript">
		$(function() {
			init();
			
			var tools = '<span id="my-tool" class="button-group">\
				<a href="javascript:void(0)" class="button icon-star">Create</a>\
				<a href="javascript:void(0)" class="button icon-download">Save</a>\
				<a href="javascript:void(0)" class="button icon-new-tab">Duplicate</a>\
				<a href="javascript:void(0)" class="button icon-trash">Delete</a>\
			</span>';
			
						
			$('#menu-list').datatable({
				tableName : 'TB_MENU',
				url : '/menu/load/page.action',
				tools : tools
			});
						

			// Table sort - DataTables
			/* var table = $('#menu-list');
			table.DataTable({
				processing : true,
				serverSide : true,
				ajax : _PATH('/menu/load/page.action'),
				pagingType : 'full',
				columns : [{
					"data" : 'id',
					"visible" : false
				}, {
					"data" : "code",
					"title" : "编码"
				}, {
					"data" : "name",
					"title" : "编码"
				}, {
					"data" : "url",
					"title" : "编码"
				}, {
					"data" : "remark",
					"title" : "编码"
				}, {
					"data" : "createTime",
					"title" : "编码"
				}, {
					"data" : "lastUpdateTime",
					"title" : "编码"
				} ],
				"order" : [ [ 1, 'desc' ] ],
				"dom" : "<'row'<'#my-tool.col-xs-6'><'col-xs-6'f>r>t<'row'<'col-xs-3'l><'col-xs-3'i><'col-xs-6'p>>",
				"language" : {
					"url" : _PATH('/pages/Chinese.json')
				},
				initComplete: function () {
					
					var tools = '<span id="my-tool" class="button-group">\
									<a href="javascript:void(0)" class="button icon-star">Create</a>\
									<a href="javascript:void(0)" class="button icon-download">Save</a>\
									<a href="javascript:void(0)" class="button icon-new-tab">Duplicate</a>\
									<a href="javascript:void(0)" class="button icon-trash">Delete</a>\
								</span>';
					$('#my-tool').append(tools);
				}
			}); */
			
			//new $.fn.dataTable.AutoFill( table );

		});
	</script>

</body>

</html>