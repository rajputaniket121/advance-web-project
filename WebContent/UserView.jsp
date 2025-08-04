<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
	String success = (String) request.getAttribute("success");
	String error = (String) request.getAttribute("error");
	UserBean bean = (UserBean) request.getAttribute("bean");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<div align="center">
		<%
		if(bean!=null && bean.getId()!=null){
		%>
		<h1>Update User</h1>
		<%
		} else {
		%>
		<h1>Add User</h1>
		<%
		}
		%>

		<%
		if (success != null) {
		%>
		<h3>
			<font color="green"><%=success%></font>
		</h3>
		<%
		}
		%>
		<%
		if (error != null) {
		%>
		<h3>
			<font color="red"><%=error%></font>
		</h3>
		<%
		}
		%>

		<form action="UserCtl" method="post">
			<table>
				<%
				if (bean != null && bean.getId()!=null) {
				%>
				<tr>
					<th></th>
					<td><input type="hidden" name="id"
						value="<%=(bean != null) ? bean.getId() : ""%>"></input></td>
				</tr>
				<%
				}
				%>
				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName"
						value="<%=(bean != null) ? bean.getFirstName() : ""%>"></input></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName"
						value="<%=(bean != null) ? bean.getLastName() : ""%>"></input></td>
				</tr>
				<tr>
					<th>Login Id :</th>
					<td><input type="text" name="loginId"
						value="<%=(bean != null) ? bean.getLoginId() : ""%>"></input></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"
						value="<%=(bean != null) ? bean.getPassword() : ""%>"></input></td>
				</tr>
				<tr>
					<th>Date of Birth :</th>
					<td><input type="date" name="dob" style="width: 98%"
						value="<%=(bean != null) ? sdf.format(bean.getDob()) : ""%>"></input></td>
				</tr>
				<tr>
					<th>Address :</th>
					<td><input type="text" name="address"
						value="<%=(bean != null) ? bean.getAddress() : ""%>"></input></td>
				</tr>
				<tr></tr>
				<tr>
					<th></th>
					<td align="center"><input type="submit"
						value="<%=(bean != null && bean.getId()!=null) ? "update" : "save"%>" name="operation"></input></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>