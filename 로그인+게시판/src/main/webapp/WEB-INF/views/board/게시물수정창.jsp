<%@page import="com.stone.springmvc.board.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Board board = (Board) request.getAttribute("board");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form  action="/board/modify" method="post">
<input type="hidden" name="no" value="<%= board.getNo() %>">
 제목<input type="text" name="title" value="<%=board.getTitle()%>"/> <br>
 내용<textarea cols="25" rows="5" name="contents"><%=board.getContents() %></textarea><br>
 <input type="submit" value="수정완료" />
</form>

</body>
</html>