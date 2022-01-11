<%@page import="java.util.ArrayList"%>
<%@page import="com.stone.springmvc.common.예약정보"%>
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
<title>좌석선택</title>

<%
String movie = (String) request.getAttribute("mv");
List<예약정보> list = (ArrayList<예약정보>) request.getAttribute("list");
%>
<script>

	var mv = "<%=movie%>";
	var selectSeatList = new Array();

	$(document).ready(function() {
		$(".not").hover(

		function() {
			if (this.style.backgroundColor != 'rgb(116, 116, 116)')
				$(this).css("background-color", "#757575");
		}, function() {
			if (this.style.backgroundColor != 'rgb(116, 116, 116)')
				$(this).css("background-color", "#4c4c4c");
		});
	});

	//선택한 좌석 전체 다 선택 해제
	function cleartd() {
		var tmp = document.getElementsByClassName("not");
		console.log(tmp.length);
		for (var i = 0; i < tmp.length; i++) {
			tmp[i].style.background = "#4c4c4c";
		}
		selectSeatList = [];
	}

	//선택한 좌석 배경색 바꾸기
	function selectSeat(seat) {
		console.log("herr");
		var co = seat.style.backgroundColor;
		if (co == 'rgb(116, 116, 116)') {
			seat.style.background = '#4c4c4c';
			selectSeatList.splice(selectSeatList.indexOf(seat.id), 1);
		} else {
			seat.style.background = 'rgb(116, 116, 116)';
			selectSeatList.push(seat.id);

		}
	}

	//예약하기 누르면 submit
	function resultSeat() {

		var url = "resister?mvname=" + mv + "&seatList="
				+ selectSeatList;
		$("a").attr("href", url);

	}
	
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
		<h1 class="tit"><%=movie%></h1>
		<form>
			<div class="inner">
				<img class="mvimg" src="imgs/<%=movie%>.jpg">
				<div id="test">
					<div id="div1"></div>
					<span>선택한좌석</span>
					<div id="div2"></div>
					<span>예약가능</span>
					<div id="div3"></div>
					<span>선택불가능</span>
				</div>
				<table class="seattable">
				<tr>
                            <td colspan="5" class="screen">screen</td>

                        </tr>
					<%
					int count = 1;
					boolean isBooked = false;
					if (list.size() != 0 && list != null) {
						for (int i = 0; i < 5; i++) {
					%>
					<tr>
						<%
						for (int k = 0; k < 5; k++) {

							for (예약정보 j : list) {
								if (j.getSno() == count) {
						%>
						<td id="<%=count%>" class="booked"><%=count%></td>
						<%
						isBooked = true;
						break;
						}
						}

						if (isBooked) {
						isBooked = false;
						} else {
						%>
						<td class="not" id="<%=count%>" onclick="selectSeat(this)"><%=count%></td>
						<%
						}
						count++;
						}
						%>
					</tr>
					<%
					}
					} else {
					for (int i = 0; i < 5; i++) {
					%><tr>
						<%
						for (int j = 0; j < 5; j++) {
						%>
						<td class="not" id="<%=count%>" onclick="selectSeat(this)"><%=count%></td>
						<%
						count++;
						}
						%>
					</tr>
					<%
					}
					%>
					<%
					}
					%>
				</table>
			</div>
		</form>
		<div class="buttons">
			<a class="btns" href="#" onclick="resultSeat()">예약하기</a> <input
				class="btns" type="button" value="좌석 다시 선택" onclick="cleartd()">

		</div>
	</div>

</body>
</html>