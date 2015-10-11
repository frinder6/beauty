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
<%-- <script type='text/javascript' src='${basePath }/dwr/interface/testController.js'></script> --%>
<script type='text/javascript' src='${basePath }/dwr/interface/PushMessage.js'></script>
<script src="${basePath }/resources/customer/my.dwr.js"></script>
<script type="text/javascript">
	/* function onPageLoad() {
		var userId = 'frinder';
		testController.onPageLoad(userId);
	}
	function showMessage(msg) {
		alert(msg);
	}
	function send() {
		testController.sendMessageAuto('frinder', 'hello world...');
	} */
	var dwr = $(document).Dwr({
		userId : 'frinder'
	});
</script>
</head>
<body onload="dwr.engine.setActiveReverseAjax(true);dwr.engine.setNotifyServerOnPageUnload(true);onPageLoad();">

	<h1>dwr测试</h1>

	<button onclick="send()">发送</button>

</body>
</html>