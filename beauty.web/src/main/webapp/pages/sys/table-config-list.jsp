<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp" flush="true" />

<body>

	<div class="with-padding">
		
		<table class="table responsive-table cell-border" id="table-config-list" cellspacing="0" width="100%">
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
			
						
			$('#table-config-list').datatable({
				tableName : 'TB_MENU',
				url : '/menu/load/page.action',
				tools : tools
			});

		});
	</script>

</body>

</html>