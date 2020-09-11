<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생성</title>
</head>
<body>
<h3>회원가입</h3>
	<form action="${pageContext.request.contextPath }/memberInsert.do" method="post">
		ID: <input name="id"><br>
		비밀번호: <input type="password" name="pw"><br>
		닉네임: <input name="nickname"><br>
		이메일: <input name="emaile"><br>
		전화번호: <input name="pnum"><br>
		<button>가입</button>
	</form>
</body>
</html>