<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>demo</title>
</head>
<body>

	Spring REST Demo
	
	<hr>
	
	<a href="${pageContext.request.contextPath}/demo/hello">Hello</a>
	<br><br>

	<a href="${pageContext.request.contextPath}/api/students">Get All Students on JSON</a>
</body>
</html>