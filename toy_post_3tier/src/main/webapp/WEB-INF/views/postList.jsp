<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Board> list = (ArrayList<Board>)request.getAttribute("boards"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>postList</title>
</head>
<body>
 <h1>게시물 목록창</h1>
   <ul>
   <%
       for(Board b : list){
   %>
   		<li><a href="detail?no=<%=b.getNo()%>"><%=b.getNo()%>. 제목 : <%=b.getTitle()%></a></li>	 	   
   <%
       }
   
   %>
   </ul>
</body>
</html>