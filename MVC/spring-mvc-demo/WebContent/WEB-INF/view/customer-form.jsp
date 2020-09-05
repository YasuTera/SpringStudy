<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/customer-form.css">
	<title>Customer Registration form</title>
</head>
<body>
	<i>苗字は必ず入力してください。</i><br>
	<form:form action="pForm" modelAttribute="customer">
		
		<p>
			苗字(*): 	<form:input path="lastName" />
					<form:errors path="lastName" cssClass="error" /><br>
			名前:	 	<form:input path="firstName" />
			
		</p><br>
		
		<p>
			FreePasses: <form:input path="freePss" />
			<form:errors path="freePss" cssClass="error" /><br>
			
			郵便番号: <form:input path="postalCode" />
			<form:errors path="postalCode" cssClass="error" /><br>
			
			コースコード: <form:input path="courseCode" />
			<form:errors path="courseCode" cssClass="error" />
		</p>
		
			<input type="submit" value="Submit" />
	
	</form:form>
</body>
</html>