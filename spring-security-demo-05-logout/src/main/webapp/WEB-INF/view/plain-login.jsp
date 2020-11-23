<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plain Custom Login Page</title>
<style>
	.failed {
		color :red;
	}
</style>
</head>
<body>
<h3>My Custom Login Page.</h3>
	<f:form action="${pageContext.request.contextPath}/authUser"
				method="POST">
				
				<!-- cログインエラーハンドラー -->
				<c:if test="${param.error != null}">
					<i class="failed">username/passwordが登録されていません</i>
				</c:if>
				
				<p>
					User name: <input type="text" name="username" />
				</p>
				<p>
					Password: <input type="password" name="password" />
				</p>
				
				<input type="submit" value="Login" />
		
	</f:form>

</body>
</html>