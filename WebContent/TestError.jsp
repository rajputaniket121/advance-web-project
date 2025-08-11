<%@ page errorPage="Error.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<%
		int age = Integer.parseInt(request.getParameter("age"));
	%>

	<h1>age = <%=age%></h1>

</body>
</html>
