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
	width: 110px;
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
             document.getElementById("post").readOnly = true;
             // 커서를 상세주소 필드로 이동한다.
             document.getElementById("detailAddress").focus();
         }
     }).open();
}

function id중복확인(){
	document.querySelector("#id").value="";
	window.open("/id","","width=350, height=300, top=100, left=450");
}

function id를받다(id){
	document.getElementById("id").value = id;
	document.getElementById("btn").hidden = true;
	document.getElementById("id").readOnly=true;
	
}

function 등록하다(){
	let name = document.querySelector("#name");
	if(name.value.trim()==""){
		alert("성명을 입력해주세요.");
		name.focus();
		return false;
	}
	let id = document.querySelector("#id");
	if(id.value.trim()==""){
		alert("ID를 입력해주세요.");
		id.focus();
		return false;
	}
	let pw = document.querySelector("#password");
	if(pw.value.trim()==""){
		alert("비밀번호를 입력해주세요.");
		pw.focus();
		return false;
	}
	let pwchk = document.querySelector("#pwchk");
	if(pw.value != pwchk.value){
		alert("비밀번호를 확인해주세요.");
		pwchk.focus();
		return false;
	}
	
	let post = document.querySelector("#post");
	if(post.value.trim() == ""){
		alert("우편번호를 입력해주세요");
		post.focus();
		return false;
	}

	let addr = document.querySelector("#address");
	if(addr.value.trim() == ""){
		alert("주소를 입력해주세요");
		addr.focus();
		return false;
	}
	
	let daddr = document.querySelector("#detailAddress");
	if(daddr.value.trim() == ""){
		alert("상세주소를 입력해주세요");
		daddr.focus();
		return false;
	}
	
	let email1 = document.querySelector("#email1");
	if(email1.value.trim() == ""){
		alert("이메일을 입력해주세요");
		email1.focus();
		return false;
	}
	email1 = email1.value;
	let email2 = document.querySelector("#email2").value;
	let email = document.querySelector("#email");
	email.value = email1.value+"@"+email2;
	console.log(email);
	return true;
	
}

</script>
</head>
<body>
	<h1>회원등록</h1>
	<!-- enctype="multipart/form-data" 파일이나 뭘 넣을땐 인코딩 타입으로 넣어줘야함  -->
	<form action="/member" enctype="multipart/form-data" method="post" onsubmit="return 등록하다()">
		<label for="name">*성명</label><input type="text" id="name" name="name" required="required"><br> 
		<label for="profile">프로필</label><img src="/img/no_img.png" id="profile" width=100 height=100/><br>
		<input type="file" name="profile" id="profile_file"><br> 		
		<label for="tel">*전화번호</label><input type="text" id="tel" name="tel" required="required"><br>
		<label for="post">*우편번호</label><input type="text" id="post" name="post" required="required" size=14 readonly="readonly"><input type="button" value="찾기" onclick="우편번호조회하다()"><br>
		<label for="address">*주소</label><input type="text" id="address" name="address" required="required"><br> 
		<label for="detailAddress">*상세주소</label><input type="text" id="detailAddress" name="detailAddress" required="required"><br>
		<label for="id">*ID</label><input type="text" id="id" name="id" required="required" size=14><input type="button" id="btn" value="중복" onclick="id중복확인()"><br>
		<label for="pw">*비밀번호</label><input type="password" id="password" name="password" required="required"><br> 
		<label for="pwchk">*비밀번호확인</label><input type="password" id="pwchk" name="pwchk" required="required"><br>
		<label>*e-mail</label><input type="text" id="email1" required="required" size=5> @
		<select id="email2">
		<option value="naver.com">naver.com</option>
		<option value="gmail.com">gmail.com</option>
		<option value="daum.net">daum.net</option>
		<option value="nate.com">nate.com</option>
		<option value="self">직접입력</option>		
		</select><br>
		<input type="hidden" name="email" id="email">
		<input type="submit" value="등록">
	</form>
</body>
<script>
function 그림파일읽어출력하기(이벤트) {
	var fileInput=이벤트.target;
    var 그림파일 = fileInput.files[0]; 
    //var size = 그림파일.size;
    /*
    if(size > 1024*10){
    	alert("10K 요량초과!");
    	fileInput.value="";
    	return ;
    }*/
    
    //image 확장자가 아닐경우
    if (!그림파일.type.match('image.*')) {
       alert("욱! 그림이 아니예요!");
       fileInput.value="";
       return ;
    }
    
    var 파일리더 = new FileReader();
    파일리더.onload = function(한그림파일) {
    	var imgProfile=document.getElementById("profile");    	  
  	 	imgProfile.src=한그림파일.currentTarget.result;
    };      
    파일리더.readAsDataURL(그림파일);
    return ;
}

//이벤트 등록
document.getElementById("profile_file").addEventListener("change", 그림파일읽어출력하기, false);

</script>

</html>