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

	<%
	Board board = (Board) request.getAttribute("modiboard");
	%>
	<form action="update" method="post">
		번호 : <input type="text" name="no" value="<%=board.getNo()%>"
			readonly="readonly"><br> 제목 : <input type="text"
			name="title" required="required" value="<%=board.getTitle()%>"/><br> 내용 :
		<textarea name="contents" cols=25 rows=5><%=board.getContents()%>"</textarea>
		<input type="submit" value="수정완료" />
	</form>
</body>
</html>