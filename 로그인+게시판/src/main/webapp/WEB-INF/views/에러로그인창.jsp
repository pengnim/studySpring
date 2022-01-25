<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<p>아이디 또는 패스워드가 일치하지않습니다.</p>

<h1>로그인</h1>
<form action="/login" method="post">
ID<input type="text" name="id" /><br>
Password<input type="password" name="password" /><br>
<input type="button" value="회원등록" />
<input type="submit" value="로그인" />
</form>
</body>
</html>