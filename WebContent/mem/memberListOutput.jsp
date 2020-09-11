<%@page import="com.dev.model.MemVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
<% ArrayList<MemVO> list = (ArrayList<MemVO>) request.getAttribute("list");
	if(!list.isEmpty()) {%>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
			
			<% for(int i = 0; i<list.size(); i++) {
				MemVO mem = list.get(i); %>
			<tr>
				<th><%=mem.getId() %></th>
				<th><%=mem.getPw() %></th>
				<th><%=mem.getNickname() %></th>
				<th><%=mem.getEmail() %></th>
				<th><%=mem.getPnum() %></th>
			</tr>
			
			<% }
			} else{
				out.print("<h3>등록된 회원정보가 없습니다.<h3>");
			}
			%>
		</table>
</body>
</html>