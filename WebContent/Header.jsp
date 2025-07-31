<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div>
		<%
		UserBean user = (UserBean) session.getAttribute("user");
		%>

		<%
		if (user != null) {	%>
		<h3>
			Hi
			<%=user.getFirstName() + " " + user.getLastName()%></h3>
			<br> <b><a href="UserCtl">AddUsers</a></b> 
			|
			<b><a
			href="UserListCtl">UserList</a></b>
				|
			<b><a
			href="LoginCtl?operation=Logout">Logout</a></b>
		<%
		} else {
		%>
			<h3>Hi ,Guest</h3>
			<br> <b><a href="WelcomeCtl">Welcome</a></b> | <b><a
			href="LoginCtl">Login</a></b>
		<%
		}
		%>
		<hr>

		<br>
	</div>
</body>
</html>