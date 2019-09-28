<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" buffer="16kb" session="false"%> <%--//directives --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@ include file="header.html" %>
<div><table><tr><td>
<form action="checkusers" method="get">
 
   
  

<p id="id3"> <img src="D:\Aditee\Adv_Java\Image\image1.jpg" style="width:50px; hegiht:50px;"><br>Sign In</p>

	<p class="para">User Name <input type="text" name="username" placeholder="Enter Username"></p>
	<p class="para">Password <input type="password" name="passwd" placeholder="Enter Password"></p>
	<p id="id5"><input type="submit" value="Sign In">
	<br>
    
</form></td></tr>
</table></div>
<%@ include file="footer.html" %>
</body>
</html>