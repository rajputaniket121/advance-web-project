<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<div align="center">
	<h1>User Registration</h1>
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
					<td align="center">
					<input type="submit" value="signIn" name ="operation"></input>
					<input type="submit" value="signUp" name ="operation"></input>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>