package com.zensar.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class WelcomeServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.setMaxInactiveInterval(5);
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		
		String logoutUrlEnc = response.encodeURL("logout");
		out.println("<p><a href='"+ logoutUrlEnc +"'>Logout </a></p>");
		
		out.println("<p>Dear "+ username+" Welcome to Online Shopping Home</p>");
		out.println("<p>Your session time out period is "+session.getMaxInactiveInterval()+" seconds</p>");
		//response.sendRedirect("www.google.com");
		out.println("<p><a href='searchInfo'>GoogleSearch</a></p>");
		out.println("<p><a href='AmazonSearch'> AmazonSearch</a></p>");
		String productUrlEnc = response.encodeURL("product");
		out.println("<p>To select products<a href='"+ productUrlEnc +"'>click here </a></p>");

		
		session.setAttribute("uname", username);
		System.out.println("Session id in welcomeServelet: "+ session.getId());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
