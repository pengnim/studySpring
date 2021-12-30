<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writePost</title>
</head>
<body>
	<p>게시물 등록</p>
	<form action="add" method="post">
		제목<input type="text" name="title" /><br> 내용
		<textarea cols="20" rows="10" name="contents" /></textarea>
		<br> <input type="submit" value="등록" />
	</form>
</body>
</html>