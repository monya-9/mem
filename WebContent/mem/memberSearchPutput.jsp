<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과</title>
</head>
<body>
<h3>검색결과</h3>
<%
	String result = (String)request.getAttribute("result");
	if(result !=null) {
		out.print(result+"<p>");
	} else {
%>
<h3>
	ID: ${mem.id }<br>
	PW: ${mem.pw }<br>
	닉네임: ${mem.nickname }<br>
	이메일: ${mem.emaile }<br>
	전화번호: ${mem.pnum }<br>
</h3>
<%} %>

</body>
</html>