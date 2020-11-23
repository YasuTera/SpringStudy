<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>

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
	</p>
	
	<hr>
	<!-- c ユーザ名　ユーザ権限　表示　 -->
	<p>
		User: <secure:authentication property="principal.username" /><br><br>
		Role(s): <secure:authentication property="principal.authorities" />
	</p>
	<hr>
	
	<!-- logout -->
	<f:form action="${pageContext.request.contextPath}/logout" method="POST" >
		
		<input type="submit" value="Logout" />
		
	</f:form>
</body>
</html>