<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
</head>
<body>

<h3>회원정보 검색</h3>

<form action="memberSearch.do" method="post">
	ID: <input type="text" name="id"/>
	<input type="hidden" name="job" value="search">
	<button>검색</button>
</form>
</body>
</html>