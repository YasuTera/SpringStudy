<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Landin' Page</title>
</head>
<body>

	<h2>This is Landing Page</h2>
	<hr>
	<p>
		Welcome to the landing page. このページは全体に公開されているページです。ログインをしていなくても閲覧できます。
	</p>
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/employees">Access Secure Site(ログインが必要です)</a>
	</p>
</body>
</html>