<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<br> <br> <br>
		<h1>
			<a href="WelcomeView.jsp">Simple url</a>
		</h1>
		<br> <br>
		<%
		String encodeUrl = response.encodeURL("WelcomeView.jsp");
		%>
		<h2>
			<a href=<%=encodeUrl%> > Encode Url  </a>
		</h2>
		<br> <br>
		<h2>
			<a href="WelcomeView.jsp?jsessionid=<%=session.getId()%>"> Hamari
				Link </a>
		</h2>
		<br> <br>
		<form action="track" method="post">
			<input type="hidden" name="jsessionid" value="<%=session.getId()%>">
			<input type="submit" value="submit">
		</form>
	</div>

</body>
</html>