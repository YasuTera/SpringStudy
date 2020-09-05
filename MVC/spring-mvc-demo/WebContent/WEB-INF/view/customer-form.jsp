<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}resources/css/customer-form.css">
	<title>Customer Registration form</title>
</head>
<body>
	<i>苗字は必ず入力してください。</i><br>
	<form:form action="pForm" modelAttribute="customer">
		
		苗字(*): <form:input path="lastName" /><br>
		名前: <form:input path="firstName" /><br>
		
		<form:errors path="lastName" cssClass="error" />
		
		<input type="submit" value="Submit" />
	
	</form:form>
</body>
</html>