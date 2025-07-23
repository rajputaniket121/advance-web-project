<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
</head>
<body>
	<div>
		<h2>User information</h2>
		<p><%=request.getParameter("firstName")%></p>
		<p><%=request.getParameter("lastName")%></p>
		<p><%=request.getParameter("loginId")%></p>
		<p><%=request.getParameter("password")%></p>
		<p><%=request.getParameter("dob")%></p>
		<p><%=request.getParameter("address")%></p>
	</div>
</body>
</html>