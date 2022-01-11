<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/fda13cdd7c.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css2/style.css">
<script>
	$(function() {
		$("#resi_ctrl").hover(function() {
			$(".menu").animate({
				opacity : 1,
				right : "0"
			}, "0.2s");
		}, function() {
			$(".menu").css("opacity", "0");
			$(".menu").css("right", "-20%");

		});
		$(".menu").hover(function() {
			$(".menu").css("opacity", "1");
			$(".menu").css("right", "0");
		}, function() {
			$(".menu").animate({
				opacity : 0,
				right : "-20%"
			}, "0.2s");
		});
	});
</script>
<title>예약완료</title>
<%
String mvname = (String) request.getAttribute("mvname");
int[] seatList = (int[]) request.getAttribute("seatList");
%>
</head>
<body>

	<form action="updateseat" method="post">
		<div class="nav">
			<ul class="tabs">
				<li id="home"><a href="callmain"><i class="fas fa-home"></i></a></li>
				<li id="resi_ctrl">Menu</li>
			</ul>
		</div>
		<div class="menu">
			<a id="cancel_menu" href="selectcancel">예약 취소</a> <a id="check_menu"
				href="checkresi">예약 확인</a> <a id="home2" href="callmain">Home</a>
		</div>
		<div class="wrap">
			<h1 class="tit">예약완료</h1>
			<div class="succinner">
				<img src="imgs/<%=mvname%>.jpg">
				<div class="contents">

					<h1 style="font-size: 3vw;"><%=mvname%></h1>
					<p style="font-size: 2vw;">예약 좌석</p>
					<p style="font-size: 2vw; margin-bottom: 1vh;"><%=Arrays.toString(seatList)%></p>
					<input class="btns" type="submit" value='처음 화면으로'>
				</div>

			</div>

		</div>
	</form>


</body>
</html>