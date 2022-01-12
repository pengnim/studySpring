<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.stone.springmvc.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Board> list = (ArrayList<Board>) request.getAttribute("boards");
int lastPageNo = (int) request.getAttribute("lastPageNo");
int pages = (int) request.getAttribute("pages");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>postList</title>
</head>
<body>
	<h1>게시물 목록창</h1>
	<ul>
		<%
		for (Board b : list) {
		%>
		<li><a href="detail?no=<%=b.getNo()%>"><%=b.getNo()%>. 제목 : <%=b.getTitle()%></a></li>
		<%
		}
		%>
	</ul>
	</ul>
	<!-- 페이지번호들 출력 -->
	<%
	for (int i = 1; i <= pages; i++) {
		if (lastPageNo == i) {
	%><a href="list?pageno=<%=i%>">[<%=i%>]
	</a> &nbsp;
	<%
	} else {
	%>
	<a href="list?pageno=<%=i%>"><%=i%> </a> &nbsp;
	<%
	}
	}
	%>
	<a href="prepare">글쓰기</a>
</body>
</html>