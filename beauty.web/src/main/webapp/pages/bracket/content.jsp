<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
	request.setAttribute("basePath", basePath);
	session.setAttribute("basePath", basePath);
%>
<html>
<head>
<jsp:include page="import-css.jsp" />
<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<h1>Welcome to the System!</h1>

	<div class="table-responsive">

		<table id="list" class="table table-bordered mb30" width="100%">
		</table>

	</div>


	<jsp:include page="import-js.jsp" />
	<script src="${basePath }/resources/customer/jquery.datatables.extends.js"></script>
	<script type="text/javascript">
		$(function() {
			var tools = '<div class="btn-group">\
				<a data-href="/pages/bracket/sys/resource-add.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
				<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
				<a class="btn btn-default fa fa-copy" data-toggle="modal" data-target=".bs-url-modal">&nbsp;导入</a>\
				<a class="btn btn-default fa fa-group" onclick="group()">&nbsp;分组</a>\
		    </div>';
		    
			var table = $('#list').DGrid({
				url : _PATH('/grid/load/id.action'),
				data : {},
				grid : {
					ajax : {
						url : _PATH('/menu/load/page.action'),
					},
					select : {
						style : 'multi'
					}
				},
				tools : tools
			});
			
			
		});
	</script>
</body>
</html>