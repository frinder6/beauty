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
<title>内容块</title>
<script src="${basePath }/resources/bracket/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${basePath }/dwr/engine.js"></script>
<script type="text/javascript" src="${basePath }/dwr/util.js"></script>
<script type='text/javascript' src='${basePath }/dwr/interface/PushMessageController.js'></script>
<script src="${basePath }/resources/customer/my.dwr.js"></script>
<script type="text/javascript">
	var dm = $(document).DwrMessage({
		userId : 'scott'
	});
	function showMessage(message){
		alert(message);
	}
</script>
</head>
<body>


	<h1>dwr测试</h1>

	<button onclick="dm.sendMsg()">发送</button>

</body>
</html>