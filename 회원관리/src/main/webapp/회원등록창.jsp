<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>회원등록창</title>
<style>
label {
	display: inline-block;
	width: 100px;
}
</style>
<script>
function 우편번호조회하다() {
	 new daum.Postcode({
		 oncomplete: function(data) {
             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

             // 각 주소의 노출 규칙에 따라 주소를 조합한다.
             // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
             var addr = ''; // 주소 변수

             //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
             if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                 addr = data.roadAddress;
             } else { // 사용자가 지번 주소를 선택했을 경우(J)
                 addr = data.jibunAddress;
             }
             

             // 우편번호와 주소 정보를 해당 필드에 넣는다.
             document.getElementById('post').value = data.zonecode;
             document.getElementById("address").value = addr;
             document.getElementById("address").readOnly = true;
             document.getElementById('post').readOnly = true;
             // 커서를 상세주소 필드로 이동한다.
             document.getElementById("detailAddress").focus();
         }
     }).open();
}

function id중복확인(){
	window.open("아이디중복확인창.jsp","","width=350, height=300, top=100, left=450");
}

function id를받다(id){
	document.getElementById("id").value = id;
	document.getElementById("btn").hidden = true;
	document.getElementById("id").readOnly=true;
	
}


</script>
</head>
<body>
	<h1>회원등록</h1>
	<form action="#" method="post">
		<label for="name">성명</label><input type="text" id="name" name="name"required="required"><br> 
		<label for="tel">전화번호</label><input type="text" id="tel" name="tel" required="required"><br>
		<label for="post">우편번호</label><input type="text" id="post" name="post" required="required" size=14><input type="button" value="찾기" onclick="우편번호조회하다()"><br>
		<label for="address">주소</label><input type="text" id="address" name="address" required="required"><br> 
		<label for="detailAddress">상세주소</label><input type="text" id="detailAddress" name="detailAddress" required="required"><br>
		<label for="id">ID</label><input type="text" id="id" name="id" required="required" size=14><input type="button" id="btn" value="중복" onclick="id중복확인()"><br>
		<label for="pw">비밀번호</label><input type="password" id="pw" name="pw" required="required"><br> 
		<label for="pwchk">비밀번호확인</label><input type="password" id="pwchk" name="pwchk" required="required"><br>
		<label for="email">e-mail</label><input type="email" id="email" name="email" required="required"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>