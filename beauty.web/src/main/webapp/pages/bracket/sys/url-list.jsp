<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<%-- <link href="${basePath }/resources/customer/my.detail.css" rel="stylesheet"> --%>

<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<%@include file="../import-search.jsp"%>
	
	<div class="table-responsive">
		<table id="list" class="table table-bordered" width="100%">
		</table>
	</div>
	<!-- table-responsive -->

	<jsp:include page="../import-js.jsp" />
	<script src="${basePath }/resources/bracket/js/custom.js"></script>
	<script type="text/javascript" src="${basePath }/resources/customer/sys/url-list.js"></script>


</body>
</html>