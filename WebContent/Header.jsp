<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Advance-web-project</title>
<link rel="icon" type="image/x-icon" href="https://www.raystec.com/assets/img/rays/favicon.png">
<meta charset="UTF-8">
</head>
<body>
	<div>
		<%
		UserBean user = (UserBean) session.getAttribute("user");
		%>
		<div>
			<a href="Index.jsp"><img align="right" style="width: 300px; height:100px; background-color: #5d5b5b;" alt="Rays Image"
				src="https://www.raystec.com/assets/img/rays/customLogoOuterglow.png"></a>
		</div>
		<div>
		<%
		if (user != null) {	%>
		<h3>
			Hi
			<%=user.getFirstName() + " " + user.getLastName()%></h3>
		<br> <b><a href="UserCtl.do">AddUsers</a></b> | <b><a
			href="UserListCtl.do">UserList</a></b> | <b><a
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
		</div>
		<br>
	</div>
	<hr>
</body>
</html>