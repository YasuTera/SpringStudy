<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客リスト</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- table section  --> 
			<table>
				<tr>
					<th>苗字 </th>
					<th>名前 </th>
					<th>Email </th>
				</tr>
				
				<!--  loop  -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<tr>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
					
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>