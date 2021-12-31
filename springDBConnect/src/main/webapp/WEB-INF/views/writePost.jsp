<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="add" method="post">
 제목 : <input type="text" name="title" required="required"/><br>
 내용 : <textarea name="contents" cols=25 rows=5></textarea>
 <input type="submit" value="전송"/>
</form>

</body>
</html>