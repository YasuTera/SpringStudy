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
	
	<!-- Add link to /leaders MANAGER権限者のみ -->
	<secure:authorize access = "hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			(for MANAGER)
		</p>
	</secure:authorize>
	
	<!-- add link to /systems ADMIN権限者のみ -->
	<secure:authorize access = "hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(for ADMIN)
		</p>
	</secure:authorize>
	<hr>
	
	<!-- logout -->
	<f:form action="${pageContext.request.contextPath}/logout" method="POST" >
		
		<input type="submit" value="Logout" />
		
	</f:form>
</body>
</html>