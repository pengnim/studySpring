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
프로필: <!-- <img id="profile" src="/img/no_image.jpg" width="200" height="300"/>--><br> 
 전화번호:${member.tel}<br>
우편번호:${member.post}<br>
주 소:${member.address}<br>
상세 주소:${member.detailAddress}<br>
ID:${member.id}<br>
E-mail:${member.email}<br>
</body>
</html>
