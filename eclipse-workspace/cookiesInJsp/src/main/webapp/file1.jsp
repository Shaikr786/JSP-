<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="file2.jsp" method="GET">
<%
Cookie username = new Cookie("username",request.getParameter("username"));
Cookie email = new Cookie("email",request.getParameter("email"));
username.setMaxAge(60*60*10);
username.setMaxAge(60*60*10);
email.setMaxAge(60*60*10);
response.addCookie(username);
response.addCookie(email);
%>
<b>Username:</b>
<%=request.getParameter("username") %>
<b>Email:</b>
<%=request.getParameter("email")%>
</form>
</body>
</html>