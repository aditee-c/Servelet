<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@ include file="header.html" %>
<%! int count = 0;
String name;
public void setName(String name){
	this.name= name;

}
public String getName(){
	return name;
}%><%--decleration --%>
<%--Scriptlet --%>
<%
	String username = request.getParameter("username");
	setName(username);
	session.setAttribute("uname",username);
	session.setMaxInactiveInterval(5);
	String productUrlEnc = response.encodeURL("product.jsp");
%>
<p>Dear <%= getName() %> Welcome to online shopping of Zensar</p>
<p>Your Session timeout period is <%= session.getMaxInactiveInterval() %>seconds</p><%--expression script --%>
<p>To view and purchase products<a href="<%= productUrlEnc %>">Click here</a></p>
<%@ include file="footer.html" %>
</body>
</html>