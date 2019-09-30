<%
String userName=request.getParameter("username");
String password=request.getParameter("passwd");
//business logic
if(userName!=null&& password!=null&& userName.equals("priya")&&password.equals("hello"))
{
	pageContext.forward("Welcome.jsp");
	
}
else
{
	out.println("sorry ! invalid username/password");
	pageContext.include("Login.jsp");
}




                
%>