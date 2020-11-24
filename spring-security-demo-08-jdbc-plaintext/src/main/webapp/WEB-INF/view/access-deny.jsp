<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page Access Denied</title>
</head>
<body>
	<h2>Access Denied -- このページを閲覧する権限はありません</h2>
	<hr>
	
	<a href="${pageContext.request.contextPath }/" >Back to Root Page</a>
</body>
</html>