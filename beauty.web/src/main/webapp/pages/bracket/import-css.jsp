<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	request.setAttribute("basePath", basePath);
	session.setAttribute("basePath", basePath);
%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="${basePath }/resources/bracket/images/favicon.png" type="image/png">

<link href="${basePath }/resources/bracket/css/bootstrap-editable.css" rel="stylesheet">
<link href="${basePath }/resources/bracket/css/style.default.css" rel="stylesheet">
<!-- database -->
<link href="${basePath }/resources/developr/js/libs/DataTables/dataTables.bootstrap.css" rel="stylesheet">
<link href="${basePath }/resources/developr/js/libs/DataTables/jquery.dataTables.css" rel="stylesheet">
<link href="${basePath }/resources/bracket/css/jquery.datatables.css" rel="stylesheet">
<link href="${basePath }/resources/developr/js/libs/DataTables/select.dataTables.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
<![endif]-->
