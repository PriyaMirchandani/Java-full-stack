<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
<%@ include file="Header.html" %>
<%!
int count=0;
String name;
public void setName(String name)
{
	this.name=name;
}
public String getName()
{
	return name;
}
%>

<%--scriptlet --%>
<%
String username=request.getParameter("username");
setName(username);
session.setAttribute("uname",username);
session.setMaxInactiveInterval(5);
String productUrlEnc=response.encodeUrl("Product.jsp");
%>

<p>dear <%=  getName() %>welcome to online shopping of zensar.</p>
<p>your session timeout period is<%=session.getMaxInactiveInterval() %>seconds</p>
<p> to view and purchase products<a href="<%=productUrlEnc %>">click here</a></p>
<%@ include file="Footer.html" %>
</body>
</html>