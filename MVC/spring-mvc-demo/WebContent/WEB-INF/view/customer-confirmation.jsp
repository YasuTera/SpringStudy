<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>

	ようこそ、 ${customer.lastName} ${customer.firstName} さん
	<br>
	Free Passes: ${customer.freePss} 
	<br>
	郵便番号: ${customer.postalCode}
	<br>
	コースコード: ${customer.courseCode}
	<br>

</body>
</html>