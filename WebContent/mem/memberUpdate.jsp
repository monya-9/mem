<%@page import="com.dev.model.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>수정 정보 검색</h3>
${error }
<form action="memberSearch.do" method="post">
ID:<input type="text" name="id">
<input type="hidden" name="nickname"value="update">
<button>검색</button>
</form>

<c:if test="${not empty mem }">


<h3>회원정보 수정</h3>
<form action="memberUpdate.do" method="post"></form>
ID: <input type="text" name="id" readonly value="${mem.id }"><br>
비밀번호: <input type="password" name="pw" value="${mem.pw }"><br>
닉네임: <input type="text" name="nickname" value="${mem.nickname }"><br>
이메일: <input type="text" name="email" value="${mem.email }"><br>
전화번호: <input type="text" name="pnum" value="${mem.pnum }"><br>
</c:if>

</body>
</html>