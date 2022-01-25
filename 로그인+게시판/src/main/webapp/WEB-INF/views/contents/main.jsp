<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% boolean isLogin=(boolean)request.getAttribute("isLogin");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(isLogin){ %>
    <button onclick="location.href='/logOut'">로그아웃</button>
     <button onclick="location.href='/board'">글쓰기</button>
    <button onclick="location.href='/member'">자기정보</button>
<%}else{ %>
	<button onclick="location.href='/login'">로그인</button>
<%} %>
<p>메인페이지</p>
</body>
</html>