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
		$(function() {
			init();

		});
	</script>

</body>

</html>