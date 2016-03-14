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



</body>
</html>