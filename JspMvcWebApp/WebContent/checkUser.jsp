<jsp:useBean id="ob" class="com.zensar.models.LoginBean" scope="request"></jsp:useBean>
<jsp:setProperty property="username" name="ob"></jsp:setProperty>
<jsp:setProperty property="password" name="ob" param="passwd"></jsp:setProperty>



<%

//invoke business logic of model
if(ob.validateUser())
{
%>
	<jsp:forward page="Welcome.jsp">
	<jsp:param value="core java" name="book1"/>
	<jsp:param value="spring"    name="book2"/>
	</jsp:forward>
<%	
}
else
{   
%>
	<p>Sorry ! Invalid Username / Password</p>;
	<jsp:include page="Login.jsp"></jsp:include>

<%  
}
%>