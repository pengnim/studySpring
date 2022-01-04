<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.stone.springmvc.common.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화선택</title>
</head>
<body>
	<%
		//회원정보 세션만들어주기 
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
		session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
	%>
	<h1>영화목록</h1>
	<ul>
		<% List<Movie> movies = (ArrayList<Movie>)request.getAttribute("movies"); 
			for(Movie m : movies){
		%>
		<li><a href="selectseat"><%=m.getMvname() %>(잔여좌석:<%=m.getLeftSeat() %>)</a></li>
		<%} %>
	</ul>
	<form action="#" method="post">
		<input type="submit" value="예약확인">
	</form>

</body>
</html>