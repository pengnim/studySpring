<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.stone.springmvc.board.common.*" %>
<% List<Board> boards= (List<Board>) request.getAttribute("boards"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 게시물목록출력 -->
<h1>게시물 목록</h1>
<ul>
<% for(int 일련번호=0;일련번호<boards.size();일련번호++){ 
	Board 게시물 =boards.get(일련번호);//zero base
%>
    <li><a href="/board/<%=게시물.getNo()%>"><%=일련번호+1 %>  <%= 게시물.getTitle() %>  <%=게시물.getWriter().getName() %> <%=게시물.getViews()  %> </a></li>
    
<%} %>
</ul>
</body>
</html>