<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//boolean isOk = true;
Boolean isOk = (Boolean) request.getAttribute("isOk");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<script>
	function 아이디중복확인() {
		document.getElementById("content").innerHTML = "사용가능한 아이디입니다. <input type='button' value='취소'><input type='submit' value='사용하기'>";
	}
	function id사용가능하다() {
		var id = document.querySelector("#id").value;
		opener.id를받다(id); //window.open한게 회원등록창 -> opener(회원등록창)한테 id전달
		close();
	}
</script>
</head>
<body>
	<h1>아이디 중복확인</h1>
	<form>
		<input type="text" name="id" id="id"><input type="submit"
			value="검사">
		<p id="content"></p>
	</form>
	<%
	if (isOk != null) {
		if (isOk) {
	%>
	사용가능한 아이디입니다.
	<input type="button" value="사용가능" onclick="id사용가능하다()">
	<%
	} else {
	%>
	이미 사용중인 아이디입니다.
	<%
	}
	}
	%>
	<input type="button" value="취소">
</body>
</html>