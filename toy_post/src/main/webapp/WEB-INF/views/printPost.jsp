<%@ page import="com.stone.springmvc.presentation.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>printPost</title>
</head>
<body>
제목 : ${board.title }<br>
내용 : ${board.contents }
</body>
</html>