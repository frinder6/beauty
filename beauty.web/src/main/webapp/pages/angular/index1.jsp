<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	request.setAttribute("basePath", basePath);
	session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html ng-app>
<head>
<meta charset="UTF-8">
<title>ANGULAR</title>
<script src="${basePath }/resources/angular/angular.js"></script>
<script src="${basePath }/resources/angular/test1.js"></script>

</head>

<body>

	<button ng-click="show = !show">Show</button>
	<div ng-show="!show">I am only visible when show is true.</div>
	<br>

	<h3>Sort:</h3>
	<select ng-model="sortModel">
		<option value="id">id</option>
		<option value="text">text</option>
	</select>
	<br>
	<ul ng-controller="ActivitiesListCtrl">
		<li ng-repeat="activity in activities | orderBy: sortModel">{{activity.id}} &gt;&gt; {{activity.text}}</li>
	</ul>
	<br> Hello {{'World'}}! Your name:
	<input type="text" ng-model="yourname" placeholder="World">
	<hr>
	Hello {{yourname || 'World'}}!


</body>
</html>