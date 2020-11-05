<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報追加ページ</title>
<link type="text/css" rel="stylesheet" href="${page.Context.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet" href="${page.Context.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
	
	<div id="container">
		<h3>顧客情報追加フォーム...</h3>
		<!-- MVC マッピング -->
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
			<!-- c 関係づけ -->
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>苗字: </label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>名前: </label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label> </label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">戻る</a>
		</p>
	</div>
</div>
</body>
</html>