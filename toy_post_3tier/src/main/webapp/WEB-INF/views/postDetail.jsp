<%@page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 상세</h1>
<% Board b = (Board)request.getAttribute("board"); %>
제목 : <%=b.getTitle() %><br>
내용<br>
<textarea cols=25 rows=5 readonly><%=b.getContents() %></textarea><br>
<a href="list">목록으로 이동</a>
<a href="prepare_update?no=<%=b.getNo()%>">수정</a>
<a href="delete?no=<%=b.getNo() %>">삭제</a>
</body>
</html>