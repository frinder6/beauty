<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<style type="text/css">
.modal .dataTables_wrapper {
	min-width: 800px;
	max-width: 800px;
	margin: 0 auto;
}
</style>
<jsp:include page="../import-js.jsp" />
<script type="text/javascript" src="${basePath }/resources/customer/sys/auth-list.js"></script>

<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div class="table-responsive">

		<table id="list" class="table table-bordered mb30" width="100%">
		</table>

	</div>
	<!-- table-responsive -->

</body>
</html>