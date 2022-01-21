<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1>
성명:${member.name}<br>
<!-- 문자열 처리하는 방법 중 한개, png로 변경 컨트롤러에 두번요청 안해도됨 -->
프로필: <img src="data:/png;base64,${profileString }" width="200" height="300"/><br> 
 전화번호:${member.tel}<br>
우편번호:${member.post}<br>
주 소:${member.address}<br>
상세 주소:${member.detailAddress}<br>
ID:${member.id}<br>
E-mail:${member.email}<br>
</body>
</html>
