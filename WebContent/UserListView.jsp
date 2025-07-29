<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<% List<UserBean> userList = (List<UserBean>) request.getAttribute("userList"); 
	Iterator<UserBean> it = userList.iterator();
	%>
	<div>
	<h1 align="center">UserList</h1>
		<form action="">
		<table border="1" style="width: 100%">
		<tr>
		<th>S.No.</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>LoginId</th>
		<th>Password</th>
		<th>DOB</th>
		<th>Address</th>
		<th>Edit</th>
		</tr>
		<%while(it.hasNext()) {
		 UserBean bean = it.next();
		%>
		<tr align="center">
		<td><%=bean.getId() %></td>
		<td><%=bean.getFirstName() %></td>
		<td><%=bean.getLastName() %></td>
		<td><%=bean.getLoginId() %></td>
		<td><%=bean.getPassword() %></td>
		<td><%=bean.getDob() %></td>
		<td><%=bean.getAddress() %></td>
		<td><a href="#">Edit</a></td>
		</tr>
		<%} %>
		</table>
		</form>
	</div>

</body>
</html>