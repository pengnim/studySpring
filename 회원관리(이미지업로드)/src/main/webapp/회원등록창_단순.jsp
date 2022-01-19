<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function 우편번호조회하다(){
	  new daum.Postcode({
          oncomplete: function(data) {
         		document.querySelector("#post").value=data.zonecode;
         		document.querySelector("#address").value=data.roadAddress;
         		
         		document.querySelector("#detailAddress").focus();
          }
      }).open();
}
function id를중복검사하다(){
	document.querySelector("#id").value="";
	window.open("/id","","width=500,height=300");
}
function id를받다(id){
	document.querySelector("#id").value=id;
}
function 회원등록하다(){
	let 성명=document.querySelector("#name").value;
	if(성명.trim()==""){
		alert("성명은 필수입력입니다.");
		return false;
	}
	let id=document.querySelector("#id").value;
	if(id.trim()==""){
		alert("아이디는 필수입력입니다.");
		return false;
	}
	let password=document.querySelector("#password").value;
	if(password.trim()==""){
		alert("패스워드는 필수입력입니다.");
		return false;
	}
	let password2=document.querySelector("#password2").value;
	if(password2.trim()==""){
		alert("패스워드는 다시 입력되야 합니다.");
		return false;
	}
	if(password!=password2){
		alert("패스워드는 동일해야 합니다.");
		return false;
	}
	let email1 = document.querySelector("#email1").value;
	let email2 = document.querySelector("#email2").value;
	let email = document.querySelector("#email");
	email.value=email1+"@"+email2;
	return true;
}

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원등록</h1>
<form onsubmit="return 회원등록하다()" action="/member" enctype="multipart/form-data" method="post"> 
성명*<input type="text" name="name" id="name" value="testname1"/><br>
프로필 <img id="profile" src="/img/no_image.jpg" width="200" height="300"/><br>
     <input type="file" name="profile" id="profileFile"/><br> 
전화번호<input type="text" name="tel" id="tel" value="010011112222"/><br>
우편번호<input type="text" name="post" id="post" value="23456"/>
     <input type="button" onclick="우편번호조회하다()" value="우편조회"/><br>
주 소<input type="text" name="address" id="address" size=30 value="서울 마표구 대흥1동"/><br>
상세 주소<input type="text" name="detailAddress" id="detailAddress" value="13-1"/><br>
ID*<input type="text" name="id" id="id" value="myid1"/>
     <input type="button" onclick="id를중복검사하다()" value="중복검사"/><br>
PassWord*<input type="password" name="password" id="password" value="testpassword1"/><br>
PassWord2*<input type="password" name="password2" id="password2" value="testpassword1"/><br>
E-mail<input type="text" id="email1" value="email1"/>@
      <select id="email2">
	    <option value="naver.com">navar.com</option>
	    <option value="daum.net">daum.net</option>
	    <option value="gmail.com">gmail.com</option>
	    <option value="직접">직접입력</option>
	  </select>
	  <input type="hidden" name="email" id="email"/>
      <br>
<input type="submit" value="등록"/>
   
</form>
</body>
</html>
<script>
function 그림파일읽어출력하기(이벤트) {
	var fileInput=이벤트.target;
	//change이벤트.target(대상)은 <input type="file" name="profileFile" id="profileFile"/>
    var 선택된그림파일관리객체 = fileInput.files[0]; 
    var 선택된그림size = 선택된그림파일관리객체.size;
     /*
    if(선택된그림size > 1024*10){
    	alert("10K 요량초과!");
    	fileInput.value="";
    	return ;
    }
     */
    if (!선택된그림파일관리객체.type.match('image.*')) {
       alert("욱! 그림이 아니예요!");
       fileInput.value="";
       return ;
    }
    var 파일리더 = new FileReader();
         파일리더.onload = function(선택된그림파일관리객체) {
  	  var imgProfile=document.getElementById("profile");    	  
  	  imgProfile.src=선택된그림파일관리객체.currentTarget.result;
    };      
    파일리더.readAsDataURL(선택된그림파일관리객체);
    return ;
}
document.querySelector("#profileFile").addEventListener("change", 그림파일읽어출력하기, false);
</script>