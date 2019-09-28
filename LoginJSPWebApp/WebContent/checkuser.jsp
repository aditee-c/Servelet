
<%
	String username = request.getParameter("username");
	String password = request.getParameter("passwd");
	//Business logic
	if (username != null && password != null && username.equals("Aditee") && password.equals("aduu")) {
		//pageContext.forward("welcome.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");//no difference in the above line and this line
		rd.forward(request, response);
	} else {
		out.println("Sorry! Invalid user Name or Password");
		pageContext.forward("login.jsp");
	}
%>