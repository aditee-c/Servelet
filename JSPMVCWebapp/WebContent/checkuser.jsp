<jsp:useBean id="ob" class="com.zensar.models.LoginBean" scope="request"></jsp:useBean>
<jsp:setProperty property="username" name="ob"/><%--introspection process value is hard coded value 
param is used if name of form field is diff from instance varianle of java class--%>
<jsp:setProperty property="password" name="ob" param="passwd"/>
<%
	//Invoke Business logic of Model
	if (ob.validateUser()) {
		//pageContext.forward("welcome.jsp");
		//RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");//no difference in the above line and this line
		//rd.forward(request, response);
		%><jsp:forward page="welcome.jsp">
		<jsp:param value="Core Java" name="book1"/>
		<jsp:param value="Spring" name="book2"/>
		
		</jsp:forward><%
	} else {
		%>
		<p>"Sorry! Invalid user Name or Password"<p>
		<%--pageContext.include("login.jsp");--%>
		<jsp:include page="login.jsp"></jsp:include>
<%	}
%>
