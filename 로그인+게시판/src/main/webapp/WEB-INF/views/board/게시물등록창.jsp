<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 등록</h1>

<form action="/board"  method="post">
 제목<input type="text" name="title" /> <br>
 내용<textarea cols="25" rows="5" name="contents" ></textarea><br>
 <input type="submit" value="등록" />
</form>
</body>
</html>