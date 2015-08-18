<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="import-css.jsp" />
<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div class="table-responsive">

		<table class="table table-bordered mb30">
			<thead>
				<tr>
					<th>#</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Username</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
				</tr>
				<tr>
					<td>4</td>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<td>5</td>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
				</tr>
				<tr>
					<td>6</td>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
				</tr>
				<tr>
					<td>7</td>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
				</tr>
			</tbody>
		</table>

	</div>
	<!-- table-responsive -->

	<jsp:include page="import-js.jsp" />
	
	<script type="text/javascript">
		$(function(){
			$(window.parent.document).find("#iframe-main").load(function() {
				var frame = $(window.parent.document).find("#iframe-main");
				var height = $(window.document).height();
				frame.height(height);
			});
		});
	</script>
</body>
</html>