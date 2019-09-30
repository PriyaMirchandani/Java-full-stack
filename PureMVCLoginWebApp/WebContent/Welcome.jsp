<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<c:set var="uname" value=" ${param.username }" scope="session"></c:set>
<c:url var="productUrlEnc"   value="Product.jsp"></c:url>

<p>dear ${param.username} welcome to online shopping of zensar.</p>
<p>your session timeout period is ${pageContext.session.maxInactiveInterval }seconds</p>
<p> to view and purchase products<a href=" ${ productUrlEnc} ">click here</a></p>


<%@ include file="Footer.html" %>
</body>
</html>