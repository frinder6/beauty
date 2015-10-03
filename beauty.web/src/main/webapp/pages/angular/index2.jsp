<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	request.setAttribute("basePath", basePath);
	session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html ng-app="app">
<head>
<meta charset="UTF-8">
<title>ANGULAR</title>
<script src="${basePath }/resources/angular/angular.js"></script>
<script src="${basePath }/resources/angular/test.js"></script>

</head>

<body ng-controller="MainCtrl">


	<span>{{ "this is some text" | capitalize }}</span>

	<input ng-model="search" type="text" />
	<ul>
		<li ng-repeat="person in developers | filter:search">{{person.name}} from {{person.country}}</li>
	</ul>

	<br> What's your name?:

	<input type="text" ng-model="user.name" ng-focus="focus" />

	<button ng-click="greet()">Click here!</button>

	<h3>{{ message }}</h3>

	<span>There are 13 phones in the basket. Total: {{ 1232.12 | currency }}</span>


</body>
</html>