<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<% String result = request.getParameter("result"); 
	if(result != null){
		%>
		<script>alert("다시로그인해주세요");</script>
		<%
	}
%>
<form action="userchk" method="post">
<fieldset>
	<legend>
		LOGIN
	</legend>
	<label for="id">ID</label>
	<input type="text" name="id" id="id"><br>
	<label for="pw">PASSWORD</label>
	<input type="password" name="pw" id="pw"><br>
	<input type="submit" value="sign-in">
	<button name="signup">sign-up</button>
</fieldset>

</form>
</body>
</html>