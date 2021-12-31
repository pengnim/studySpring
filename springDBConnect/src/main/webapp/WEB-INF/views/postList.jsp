<%@ page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>printPost</title>
</head>
<body>
 <h1>게시물 목록창</h1>
   <ul>
   <%
       for(int i=1; i<= 20; i++){
   %>
   		<li>제목<%=i%> 작성자<%=i%></li>	 	   
   <%
       }
   
   %>
   </ul>
</body>
</html>