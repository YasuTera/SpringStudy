<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is root page.</title>
</head>
<body>
	<h2>Welcome</h2>
	<hr>
	<p>
	Welcome to the root(main) page.
	
	<!-- logout -->
	<f:form action="${pageContext.request.contextPath}/logout" method="POST" >
		
		<input type="submit" value="Logout" />
		
	</f:form>
	</p>
</body>
</html>