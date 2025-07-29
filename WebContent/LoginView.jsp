<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div align="center">
		<%
		String success = (String) request.getAttribute("success");
		String error = (String) request.getAttribute("error");
		%>
		<h1>User Login</h1>
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
			<font color="Red"><%=error%></font>
		</h3>
		<%
		}
		%>
		<form action="LoginCtl" method="post">
			<table>
				<tr>
					<th>Login Id :</th>
					<td><input type="text" name="loginId"></input></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"></input></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<th></th>
					<td align="center"><input type="submit" value="signIn"
						name="operation"></input> <input type="submit" value="signUp"
						name="operation"></input></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>