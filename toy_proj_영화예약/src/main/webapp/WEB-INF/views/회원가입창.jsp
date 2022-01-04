<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<form action="#" method="post">
		<fieldset>
			<legend> SIGN UP </legend>
			<label for="id">ID</label> <input type="text" name="id" id="id">
			<button name="chkid">중복확인</button>
			<br> <label for="pw">PASSWORD</label> <input type="password"
				name="pw" id="pw"><br> <label for="pwchk">PASSWORD
				CHECK</label> <input type="password" name="pwchk" id="pwchk"><br>
			<input type="submit" value="회원가입하기"> <input type="reset"
				value="취소">
		</fieldset>
	</form>

</body>

</body>
</html>