<%@ taglib 
	prefix="form" 
    uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration form</title>
</head>
<body>
	<form:form action="pForm" modelAttribute="student">
		苗字: <form:input path="lastName" /><br>
		名前: <form:input path="firstName" /><br>
		国籍:<form:select path="country">
			<!-- calling student.getCountryOptions() -->
			<form:options items="${student.countryOptions}" />
		</form:select><br>
		好きな言語: 
			Java <form:radiobutton path="favoriteLang" value="Java" />
			C# <form:radiobutton path="favoriteLang" value="C#" />
			PHP <form:radiobutton path="favoriteLang" value="PHP" />
			Ruby <form:radiobutton path="favoriteLang" value="Ruby" />
		<br>
		使用OS: 
			Linux　<form:checkbox path="operatingSys" value="Linux" />
			Mac OS　<form:checkbox path="operatingSys" value="Mac OS" />
			MS Windows　<form:checkbox path="operatingSys" value="MS Windows" />
		<br>
		
		
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>