<%@page import="java.util.ArrayList"%>
<%@page import="com.pengnim.movie.common.예약정보"%>
<%@page import="java.util.List"%>
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

<title>예약확인</title>
<script>
	$(function() {
		var h = $(".cancelul").height();
		var offs = $(".cancelul").offset().top;
		var sum = h + offs;
		console.log(sum);

		$(".cancelsubmit").css({
			top : sum - 80
		});

	});
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
</head>
<body>
	<%
	List<예약정보> list = (ArrayList<예약정보>) request.getAttribute("resiList");
	%>
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
	<form action="callmain" method="post">

		<div class="wrap">
			<h1 class="tit">예약번호 - 영화이름 - 좌석번호</h1>
			<ul class="cancelul">

				<%
				for (예약정보 l : list) {
				%>

				<li class="cancelno">no.<%=l.getNo()%> - <%=l.getMvname()%> <%=l.getSno()%></li>

				<%
				}
				%>

			</ul>
			<input class="cancelsubmit" type="submit" value="처음으로">
		</div>
	</form>


</body>
</html>