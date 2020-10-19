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
		
		<!--  -->
		<input type="button" value="追加" 
			onclick="window.location.href='showAddForm'; return false"
			class="add-button"
		/>
			
			<!-- table section  --> 
			<table>
				<tr>
					<th>苗字 </th>
					<th>名前 </th>
					<th>Email </th>
					<th> </th>
				</tr>
				
				<!--  loop  -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<!-- c　編集時データが入るように  -->
					<c:url var="updateLink" value="/customer/showUpdForm">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<tr>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.email}</td>
						
						<!-- updatelinks  -->
						<td>
							<a href="${updateLink}">編集</a>
						</td>
					</tr>
					
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>