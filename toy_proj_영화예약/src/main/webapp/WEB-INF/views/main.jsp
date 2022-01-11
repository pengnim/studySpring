<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.stone.springmvc.common.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/fda13cdd7c.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="css2/style.css">
    <title>Main</title>
    <script>
        $(function () {
            $("#resi_ctrl").hover(function () {
                $(".menu").animate({opacity:1, right:"0"},"0.2s");
            }, function () {
                $(".menu").css("opacity", "0");
                $(".menu").css("right","-20%");
                
            });
            $(".menu").hover(function () {
                $(".menu").css("opacity", "1");
                $(".menu").css("right","0");
            }, function () {
                $(".menu").animate({opacity:0, right:"-20%"},"0.2s");
            });
        });

    </script>
</head>
<body>
	<div class="nav">
        <ul class="tabs">
            <li id="home"><a href="callmain"><i class="fas fa-home"></i></a></li>
            <li id="resi_ctrl">Menu</li>
        </ul>
    </div>
    <div class="menu">
        <a id="cancel_menu" href="selectcancel">예약 취소</a>
        <a id="check_menu" href="checkresi">예약 확인</a>
        <a id="home2" href="callmain">Home</a>
    </div>
	<div class="wrap" style="flex-direction: column;">
	<h1 class="tit" style="transform: translateX(-20vw) translateY(3vh);">영화 예약</h1>
	<ul class="mvul">
		<%
		List<Movie> movies = (ArrayList<Movie>) request.getAttribute("movies");
		for (Movie m : movies) {
			if (m.getRemainingSeat() != 0) {
		%>
		<li class="mvli"><a href="selectseat?mvname=<%=m.getMvname()%>"><img src="imgs/<%=m.getMvname()%>.jpg"><%=m.getMvname()%><br>(잔여좌석:<%=m.getRemainingSeat()%>)</a></li>
		<%
		} else {
		%>
		<li class="noSeat"><img src="imgs/<%=m.getMvname()%>.jpg"><%=m.getMvname()%><br>(잔여좌석:<%=m.getRemainingSeat()%>)</li>
		<%
		}
		}
		%>
	</ul>
	</div>

</body>
</html>