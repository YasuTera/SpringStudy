<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		
		<!-- c 新規追加 -->
		<input type="button" value="追加" 
			onclick="window.location.href='showAddForm'; return false"
			class="add-button"
		/>
		
		<!-- c　検索フォーム -->
		<form:form action="search" method="GET">
			検索: <input type="text" name="searchName" />
		
			<input type="submit" value="Search" class="add-button" />
		</form:form>
			
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
					<!--  c 編集  -->
					<c:url var="updateLink" value="/customer/showUpdForm">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<!--  c 削除  -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<tr>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.email}</td>
						
						<!-- updatelinks  -->
						<td>
							<a href="${updateLink}">編集</a>
							|
							<a href="${deleteLink}" onclick="if(!(confirm('本当に削除しますか?')))  return false">削除</a>
						</td>
					</tr>
					
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>