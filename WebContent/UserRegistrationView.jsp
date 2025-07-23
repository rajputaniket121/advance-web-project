<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
	<div align="center">
	<h1>User Registration</h1>
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
					<th>Mobile No  :</th>
					<td><input type="number" name="mobileNo"></input></td>
				</tr>
				<tr>
					<th>Role Id  :</th>
					<td><input type="number" name="roleId"></input></td>
				</tr>
				<tr>
					<th>Gender :</th>
					<td><input type="text" name="gender"></input></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="signUp"></input></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>