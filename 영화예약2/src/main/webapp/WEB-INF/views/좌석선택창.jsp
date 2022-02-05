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
<title>좌석선택</title>

<%
String movie = (String) request.getAttribute("mv");
%>
<script>

	var mv = "<%=movie%>"; //영화이름저장
	var selectSeatList = new Array(); //선택한 좌석을 저장할 배열

	
	//좌석hover
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
		var tmp = document.getElementsByClassName("not"); //예약되지않은 좌석들
		for (var i = 0; i < tmp.length; i++) {
			tmp[i].style.background = "#4c4c4c"; //모든 좌석 색 원래대로 돌리기
		}
		selectSeatList = []; //선택좌석배열 비우기
	}

	//선택한 좌석 배경색 바꾸기(class not에 할당된 onclick event함수)
	function selectSeat(seat) {
		var seatColor = seat.style.backgroundColor;
		if (seatColor == 'rgb(116, 116, 116)') { //이미 선택된 좌석이면 다시 선택하지 않은걸로 만들기
			seat.style.background = '#4c4c4c';
			selectSeatList.splice(selectSeatList.indexOf(seat.id), 1); //선택취소한 좌석을 배열에서 제거 
		} else {
			seat.style.background = 'rgb(116, 116, 116)';
			selectSeatList.push(seat.id); //선택된 좌석 번호 배열에 넣기

		}
	}

	//예약하기 누르면 submit
	function resultSeat() {

		var url = "resister?mvname=" + mv + "&seatList="+ selectSeatList; //변수매핑해서 넘겨주기
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
					int idValue = 1; //좌석에 ID를 부여할 때 쓰는 변수, 아이디값이 곧 좌석번호
					boolean isBooked = false; //좌석당 예약 여부 확인, true=예약됨, false=예약안됨
					List<예약정보> list = (ArrayList<예약정보>) request.getAttribute("list");
					if (list.size() != 0 && list != null) { //리스트가 비어있지않으면
						for (int i = 0; i < 5; i++) {
					%>
					<tr>
						<%
						for (int k = 0; k < 5; k++) { //5*5칸으로 테이블생성

							for (예약정보 j : list) {//예약리스트 갯수만큼 돌기, 현재idValue가 예약된 좌석인지 확인하기 위해 돔
								//예약된 좌석 번호와 현재 좌석의 번호가 같으면
								//class를 booked로 부여해서 선택할 수 없게 설정
								if (j.getSno() == idValue) { 
						%>
						<td id="<%=idValue%>" class="booked"><%=idValue%></td> 
						<%
						isBooked = true;//예약된 좌석이였으니 true
						break;
						}
						}

						if (isBooked) {
						isBooked = false; //다음 좌석 예약 여부를 판단하기 위해 false
						} else {
							//class를 not으로 부여해 선택할 수 있도록 설정
						%>
						<td class="not" id="<%=idValue%>" onclick="selectSeat(this)"><%=idValue%></td>
						<%
						}
						idValue++;
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
						<td class="not" id="<%=idValue%>" onclick="selectSeat(this)"><%=idValue%></td>
						<%
						idValue++;
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