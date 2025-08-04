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
	<%
	List<UserBean> userList = (List<UserBean>) request.getAttribute("userList");
	int pageNo = (int) request.getAttribute("pageNo");
	int index = ((pageNo -1) * 5 ) + 1 ;
	Iterator<UserBean> it = userList.iterator();
	String success = (String) request.getAttribute("success");
	String error = (String) request.getAttribute("error");
	%>
	<div align="center">
		<h1 >Users List</h1>
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
			<font color="red"><%=error%></font>
		</h3>
		<%
		}
		%>
		<form action="UserListCtl" method="post">
			<div align="center">
				<table>
					<tr>
						<th>First Name:</th>
						<td><input type="text" name="firstName"
							placeholder="enter first name here">&nbsp; &nbsp;</td>
						<th>Date of birth:</th>
						<td><input type="date" name="dob">&nbsp; &nbsp;</td>
						<td><input type="submit" name="operation" value="search"></td>
					</tr>
				</table>
				<br> <br>
			</div>
			<table border="1" style="width: 100%">
				<tr>
				<th>Select</th>
					<th>S.No.</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>LoginId</th>
					<th>Password</th>
					<th>DOB</th>
					<th>Address</th>
					<th>Edit</th>
				</tr>
				<%
				if (userList != null && userList.size() > 0) {
					while (it.hasNext()) {
						UserBean bean = it.next();
				%>
				<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLoginId()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getDob()%></td>
					<td><%=bean.getAddress()%></td>
					<td><a href="UserCtl?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
				}
				} else if(userList.size()==0) {
				%>
				<tr style="width: 100%">
					<td align="center" colspan="9"><font style="color: red"><b>No
								records Found</b></font></td>
				</tr>
				<%
				}
				%>
			</table>
			<br>
			<table style="width: 100%">
				<tr>
					<td style="width: 30%"><input type="submit" value="previous"
						name="operation" <%=(pageNo == 1) ? "disabled" : ""%>></td>
					<td style="width: 30%"><input type="submit" value="add"
						name="operation"></td>
					<td style="width: 25%"><input type="submit" value="delete"
						name="operation"></td>
					<td style="text-align: right;"><input type="submit"
						value="next" name="operation"
						<%=(userList.size() < 5) ? "disabled" : ""%>></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="hidden" name="pageNo" value="<%=pageNo%>">
					</td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>