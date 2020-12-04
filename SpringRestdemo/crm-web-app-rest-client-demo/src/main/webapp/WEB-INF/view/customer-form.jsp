<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>顧客情報管理画面</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
	<meta charset="UTF-8">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>顧客管理</h2>
		</div>
	</div>

	<div id="container">
		<h3>顧客情報</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>苗字:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
				
					<tr>
						<td><label>名前: </label></td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td><label>Email:　</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="保存" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">一覧へ</a>
		</p>
	
	</div>

</body>

</html>










