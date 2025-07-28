<%@ page import="in.co.rays.bean.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Advance-web-project</title>
</head>
<body>
<% UserBean bean = (UserBean) request.getAttribute("user"); %>
	<div align="center">
	<% if(bean!=null) {%>
	<h2><font color="Red"><%= bean.getFirstName() +" "+bean.getLastName() %></font></h2>
	<%} %>
	<h1>Welcome To Advance Web Project</h1>
	</div>
</body>
</html>