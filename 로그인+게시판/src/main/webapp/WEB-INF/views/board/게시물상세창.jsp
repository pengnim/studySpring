<%@page import="com.stone.springmvc.board.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Boolean isWriter = (Boolean) request.getAttribute("isWriter");
	Board board = (Board) request.getAttribute("board");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제목 : <%= board.getTitle() %><br>
작성자 : <%= board.getWriter().getNo() %> 조회수 : <%= board.getViews() %><br>
내용 : <%= board.getContents() %><br>

<%
	if(isWriter != null && isWriter){
		%>
		<a href="#">수정</a>
		<a href="#">삭제</a>
		<% 
	}
%>
<a href="/boards">목록으로</a>

</body>
</html>