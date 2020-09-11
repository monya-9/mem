<%@page import="com.dev.model.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>삭제 정보 검색</h3>
	${error }
	<from action="memberSearch.do" method="post">
	ID: <input type="text" name="id">
	<input type="hidden" name="job" value="delete">
	<button>검색</button>
	</from>
	
	<%MemVO mem = (MemVO)request.getAttribute("member");
		if(mem != null) { %>
		<h3>검색 정보 결과</h3>
		ID: ${member.id }<br>
		PW: ${member.pw }<br>
		: ${member.gender }<br>
		: ${member.reason }<br>
		${member.job }<br>
		${member.hobby }<br>
		
		<form action="memberDelete.do" method="post">
			<input type="hidden" name="id" value="${member.di }">
			<button>삭제</button>
		</form>
		<%}else{ %>
		${result} <p>
	<% }%>
</body>
</html>