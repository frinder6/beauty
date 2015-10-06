
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
	request.setAttribute("basePath", basePath);
	session.setAttribute("basePath", basePath);
%>
<script type="text/javascript">
	window.location = '${basePath}/pages/bracket/login.jsp';
</script>

