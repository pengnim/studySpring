<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //boolean 사용가능= true;//(boolean)request.getAttribute("usable");
    Boolean 사용가능= (Boolean)request.getAttribute("usable");
    String id=(String)request.getAttribute("id");
%>    
<!DOCTYPE html>
<html>
<head>
<script>
function id사용하다(){
	var id=document.querySelector("#id").value;
	opener.id를받다(id);
	close();
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>아이디 중복 확인</h1>
<form action="/id" method="post"> 
ID<input type="text" name="id" id="id" value="<%=(id==null)?"":id%>"/>
  <input type="submit" value="검사"/>
<br>
</form>
<% if(사용가능!=null){
if(사용가능){ %>
	사용 가능한 id입니다. <input type="button" onclick="id사용하다()" value="사용"/>
<%}else{ %>
    이미 사용 중 입니다.
<%} 
}%>
<input type="button" value="취소"/>
</body>
</html>