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
	%>
	<div align="center">
		<h1>User Registration</h1>

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
		<form action="UserRegistrationCtl" method="post">
			<table>
				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName"></input></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName"></input></td>
				</tr>
				<tr>
					<th>Login Id :</th>
					<td><input type="text" name="loginId"></input></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"></input></td>
				</tr>
				<tr>
					<th>Date of Birth :</th>
					<td><input type="date" name="dob" style="width: 98%"></input></td>
				</tr>
				<tr>
					<th>Mobile No :</th>
					<td><input type="number" name="mobileNo"></input></td>
				</tr>
				<tr>
					<th>Role Id :</th>
					<td><input type="number" name="roleId"></input></td>
				</tr>
				<tr>
					<th>Gender :</th>
					<td><input type="text" name="gender"></input></td>
				</tr>
				<tr>
					<th>Created By :</th>
					<td><input type="text" name="createdBy"></input></td>
				</tr>
				<tr>
					<th>Modified By :</th>
					<td><input type="text" name="modifiedBy"></input></td>
				</tr>
				<tr></tr>
				<tr>
					<th></th>
					<td align="center"><input type="submit" value="signUp"></input></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>