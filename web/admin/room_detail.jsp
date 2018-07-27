<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<!-- set the encoding of your site -->
	<meta charset="utf-8">
	<!-- set the viewport width and initial-scale on mobile devices -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Hotel</title>
	<!-- include the site stylesheets -->
	<link rel="stylesheet" href="detail/css/bootstrap.css" type="text/css" media="all">
	<link rel="stylesheet" href="detail/css/style.css" type="text/css" media="all">
	<link rel="stylesheet" href="detail/css/colors.css" type="text/css" media="all">
	<link rel="stylesheet" href="detail/css/jquery.countdown.css" type="text/css">
	<link rel="stylesheet" href="detail/css/animations.min.css" type="text/css" media="all">
	<link rel="stylesheet" href="detail/css/datepicker.css" type="text/css" media="all">
	<!-- Bootstrap Dropdown Hover CSS -->
	<link rel="stylesheet" href="detail/css/animate.min.css" type="text/css" media="all">
	<link rel="stylesheet" href="detail/css/bootstrap-dropdownhover.min.css" type="text/css"
		  media="all">
	<!-- Fonts CSS -->
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lora:400,400italic,700" type="text/css">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" type="text/css">
	<!-- Range slider CSS -->
	<link rel="stylesheet prefetch" href="detail/css/jquery-ui.css" type="text/css">
	<!-- flex slider CSS -->
	<link rel="stylesheet" href="detail/css/flexslider.css" type="text/css">
</head>
<body>
	<!-- main container of all the page elements -->
	<div id="wrapper">
		<!-- header -->

		<!-- banner -->

		<!-- Navigation -->
		<div class="navigation-bar">
			<div class="container">
				<div class="row">

				</div>
			</div>
		</div>
		<!-- contain main informative part of the site -->
		<main id="main">
			<!-- Room details -->
			<section class="room-details container gen-padding">
				<div class="row">
					<div class="col-sm-6">
						<div id="flex-slider" class="flexslider">
							<ul class="slides">
								<c:forEach var="p" items="${pic}" >
								<li>
									<img src="${p}" alt="image description">
								</li>
								</c:forEach>
							</ul>
						</div>
						<div id="thumbnails" class="flexslider">
							<ul class="slides">
								<c:forEach var="p" items="${pic}" >
								<li> <img src="${ p}" alt="image description"> </li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-6 info-frame">
						<h1>deluxe room</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor  incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud  exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
						<ul class="detail-list list-unstyled">
							<li><strong>房间号:</strong> ${detail[0].getRoom_Num()}</li>
							<li><strong>房间人数:</strong> ${detail[0].getRoom_PersCount()}</li>
							<li><strong>房间物品:</strong> ${detail[0].getRoom_Things()}</li>
							<li><strong>房间面积:</strong> ${detail[0].getRoom_Area()}</li>
						</ul>
						<div class="btn-holder">

							<strong class="rent-price">${detail[0].getHire_Money() } <span>押金</span></strong>
						</div>
					</div>
				</div>
			</section>
			<!-- Description block -->

							<!-- Controls -->


		</main>


	<!-- include jQuery library -->
	<script type="text/javascript" src="detail/js/jquery-1.11.2.min.js"></script>

	<script type="text/javascript" src="detail/js/bootstrap.min.js"></script>
	<!-- Range Slider JavaScript -->
	<script type="text/javascript" src='detail/js/jquery-ui.min.js'></script>
	<script type="text/javascript" src='detail/js/range-slider.js'></script>
	<!-- Same Height JavaScript -->
	<script type="text/javascript" src='detail/js/same-height.js'></script>
	<!-- include custom JavaScript -->
	<script type="text/javascript" src="detail/js/jquery.main.js"></script>
	<script type="text/javascript" src="detail/js/animations.min.js"></script>
	<script type="text/javascript" src="detail/js/jquery.plugin.js"></script>
	<script type="text/javascript" src="detail/js/jquery.countdown.js"></script>
	<script type="text/javascript" src="detail/js/timber.master.min.js"></script>
	<!-- Bootstrap Dropdown Hover JS -->
	<script type="text/javascript" src="detail/js/bootstrap-dropdownhover.min.js"></script>
	<script type="text/javascript" src="detail/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" defer src="detail/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="detail/js/myscript.js"></script>
</body>
</html>