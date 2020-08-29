<%@ taglib 
	prefix="form" 
    uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration form</title>
</head>
<body>
	<form:form action="pForm" modelAttribute="student">
		苗字: <form:input path="lastName" /><br>
		名前: <form:input path="firstName" /><br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>