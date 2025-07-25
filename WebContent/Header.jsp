<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div>
	<%! String name = (2/2!=0)?"Aniket":"Guest"; %>
		<h3>Hi <%=name %>!</h3>
		<% out.println("This is a dynamic message "+name); %>
		<br> <b><a href="WelcomeCtl">Welcome</a></b> | <b><a
			href="LoginCtl">Login</a></b>
		<hr>

		<br>
		<br>
	</div>
</body>
</html>