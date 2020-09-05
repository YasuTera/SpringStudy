<%@ taglib 
	prefix="form" 
    uri="http://www.springframework.org/tags/form" %>
<%@ taglib 
	prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Confirmation</title>
</head>
<body>
	生徒が登録されました：  ${student.firstName} ${student.lastName}
	<br>
	国籍： ${student.country}
	<br>
	好きな言語： ${student.favoriteLang}
	<br>
	使用言語:
		<ul>
			<c:forEach var="temp" items="${student.operatingSys}">
			<li>${temp}</li>
			</c:forEach>
		</ul>
</body>
</html>