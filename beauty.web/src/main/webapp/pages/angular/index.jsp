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
<script src="${basePath }/resources/angular/main.js"></script>

</head>

<body>

	<button ng-click="counter = counter + 1">Add one</button>
	Current counter: {{ counter }}
	<br>
	<b ng-init='name = "Ari Lerner"'>Hello, {{ name }}</b>


	<div ng-controller="PlayerController">
		<button ng-click="play()" class="button" ng-show="!playing">Play</button>
		<button ng-click="stop()" class="button alert" ng-show="playing">Stop</button>
		Playing audio: <b>{{ playing }}</b>
	</div>

	{{name}}


	<div ng-controller="MyController">{{ person.name }}</div>

	<div ng-controller="ParentController">
		<div ng-controller="ChildController">
			<input type="text" ng-model="person.name" placeholder="Name"></input> <a ng-click="sayHello()">Say hello</a>
		</div>
		{{ person }}
	</div>




</body>
</html>