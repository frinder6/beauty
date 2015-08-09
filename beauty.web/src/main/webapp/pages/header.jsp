<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	request.setAttribute("basePath", basePath);
	session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>

<!--[if IEMobile 7]><html class="no-js iem7 oldie"><![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js ie7 oldie" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js ie8 oldie" lang="en"><![endif]-->
<!--[if (IE 9)&!(IEMobile)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|(gt IEMobile 7)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>后台管理系统</title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">

<meta name="viewport" content="user-scalable=0, initial-scale=1.0, target-densitydpi=115">

<!-- For all browsers -->
<link rel="stylesheet" href="${basePath}/resources/developr/css/reset.css?v=1">
<link rel="stylesheet" href="${basePath}/resources/developr/css/style.css?v=1">
<link rel="stylesheet" href="${basePath}/resources/developr/css/colors.css?v=1">
<link rel="stylesheet" media="print" href="${basePath}/resources/developr/css/print.css?v=1">
<!-- For progressively larger displays -->
<link rel="stylesheet" media="only all and (min-width: 480px)" href="${basePath}/resources/developr/css/480.css?v=1">
<link rel="stylesheet" media="only all and (min-width: 768px)" href="${basePath}/resources/developr/css/768.css?v=1">
<link rel="stylesheet" media="only all and (min-width: 992px)" href="${basePath}/resources/developr/css/992.css?v=1">
<link rel="stylesheet" media="only all and (min-width: 1200px)" href="${basePath}/resources/developr/css/1200.css?v=1">
<!-- For Retina displays -->
<link rel="stylesheet" media="only all and (-webkit-min-device-pixel-ratio: 1.5), only screen and (-o-min-device-pixel-ratio: 3/2), only screen and (min-device-pixel-ratio: 1.5)" href="${basePath}/resources/developr/css/2x.css?v=1">

<!-- Webfonts -->
<link href='http://fonts.useso.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

<!-- Additional styles -->
<link rel="stylesheet" href="${basePath}/resources/developr/css/styles/agenda.css?v=1">
<link rel="stylesheet" href="${basePath}/resources/developr/css/styles/dashboard.css?v=1">
<link rel="stylesheet" href="${basePath}/resources/developr/css/styles/form.css?v=1">
<link rel="stylesheet" href="${basePath}/resources/developr/css/styles/modal.css?v=1">
<link rel="stylesheet" href="${basePath}/resources/developr/css/styles/progress-slider.css?v=1">
<link rel="stylesheet" href="${basePath}/resources/developr/css/styles/switches.css?v=1">
<link rel="stylesheet" href="${basePath}/resources/developr/css/styles/table.css?v=1">

<!-- DataTables -->
<link rel="stylesheet" href="${basePath}/resources/developr/js/libs/DataTables/jquery.dataTables.css?v=1">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}/resources/bootstrap/datatable/dataTables.bootstrap.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${basePath}/resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${basePath}/resources/bootstrap/css/bootstrap.min.css">


<!-- JavaScript at bottom except for Modernizr -->
<script src="${basePath}/resources/developr/js/libs/modernizr.custom.js"></script>

<!-- For Modern Browsers -->
<link rel="shortcut icon" href="${basePath}/resources/developr/img/favicons/favicon.png">
<!-- For everything else -->
<link rel="shortcut icon" href="${basePath}/resources/developr/img/favicons/favicon.ico">

<!-- iOS web-app metas -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!-- iPhone ICON -->
<link rel="apple-touch-icon" href="${basePath}/resources/developr/img/favicons/apple-touch-icon.png" sizes="57x57">
<!-- iPad ICON -->
<link rel="apple-touch-icon" href="${basePath}/resources/developr/img/favicons/apple-touch-icon-ipad.png" sizes="72x72">
<!-- iPhone (Retina) ICON -->
<link rel="apple-touch-icon" href="${basePath}/resources/developr/img/favicons/apple-touch-icon-retina.png" sizes="114x114">
<!-- iPad (Retina) ICON -->
<link rel="apple-touch-icon" href="${basePath}/resources/developr/img/favicons/apple-touch-icon-ipad-retina.png" sizes="144x144">

<!-- iPhone SPLASHSCREEN (320x460) -->
<link rel="apple-touch-startup-image" href="${basePath}/resources/developr/img/splash/iphone.png" media="(device-width: 320px)">
<!-- iPhone (Retina) SPLASHSCREEN (640x960) -->
<link rel="apple-touch-startup-image" href="${basePath}/resources/developr/img/splash/iphone-retina.png" media="(device-width: 320px) and (-webkit-device-pixel-ratio: 2)">
<!-- iPhone 5 SPLASHSCREEN (640×1096) -->
<link rel="apple-touch-startup-image" href="${basePath}/resources/developr/img/splash/iphone5.png" media="(device-height: 568px) and (-webkit-device-pixel-ratio: 2)">
<!-- iPad (portrait) SPLASHSCREEN (748x1024) -->
<link rel="apple-touch-startup-image" href="${basePath}/resources/developr/img/splash/ipad-portrait.png" media="(device-width: 768px) and (orientation: portrait)">
<!-- iPad (landscape) SPLASHSCREEN (768x1004) -->
<link rel="apple-touch-startup-image" href="${basePath}/resources/developr/img/splash/ipad-landscape.png" media="(device-width: 768px) and (orientation: landscape)">
<!-- iPad (Retina, portrait) SPLASHSCREEN (2048x1496) -->
<link rel="apple-touch-startup-image" href="${basePath}/resources/developr/img/splash/ipad-portrait-retina.png" media="(device-width: 1536px) and (orientation: portrait) and (-webkit-min-device-pixel-ratio: 2)">
<!-- iPad (Retina, landscape) SPLASHSCREEN (1536x2008) -->
<link rel="apple-touch-startup-image" href="${basePath}/resources/developr/img/splash/ipad-landscape-retina.png" media="(device-width: 1536px)  and (orientation: landscape) and (-webkit-min-device-pixel-ratio: 2)">

<!-- Microsoft clear type rendering -->
<meta http-equiv="cleartype" content="on">

<meta name="application-name" content="Developr Admin Skin">
<meta name="msapplication-tooltip" content="Cross-platform admin template.">
<meta name="msapplication-starturl" content="http://www.display-inline.fr/demo/developr">
<!-- These custom tasks are examples, you need to edit them to show actual pages -->
<meta name="msapplication-task" content="name=Agenda;action-uri=http://www.display-inline.fr/demo/developr/agenda.html;icon-uri=http://www.display-inline.fr/demo/developr/img/favicons/favicon.ico">
<meta name="msapplication-task" content="name=My profile;action-uri=http://www.display-inline.fr/demo/developr/profile.html;icon-uri=http://www.display-inline.fr/demo/developr/img/favicons/favicon.ico">




</head>