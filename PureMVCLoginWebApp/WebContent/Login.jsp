<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" buffer="16kb" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
  <%@ include file="Header.html" %>
<form action="checkuser" method="get">
  <p>Username: <input type="text"      name="username"   placeholder="Enter Username"></p>
  <p>Password: <input type="password"  name="passwd"     placeholder="Enter Password"></p>
  <p><input type="submit" value="SignIn"></p>
  </form>
  <%@ include file="Footer.html" %>
</body>
</html>