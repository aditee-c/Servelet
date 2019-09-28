package com.zensar.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

/**
 * Servlet implementation class LoginServelet
 */
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//call business layer component
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext context = config.getServletContext();//servlet context object represent entire web application here context is representing the same 
		//created only once and available to all servlet as common
		
		String driverClassName = context.getInitParameter("jdbcDriver");
		String dbUrl = context.getInitParameter("jdbcUrl");
		String dbUsername = context.getInitParameter("dbUser");
		String dbPassword = context.getInitParameter("dbPassword");
		//Load jdbc driver
		try {
			Class.forName(driverClassName);
			context.log("Jdbc Driver is loaded successfully");
			//establish database connection
			Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			context.log("my sql database connection is established");
			//create userdao object
			UserDao userDao = new UserDaoImpl();
			((UserDaoImpl) userDao).setConnection(con);
			//create user service object
			UserService userService = new UserServiceImpl();
			((UserServiceImpl) userService).setUserDao(userDao);
			//set userService to a servlet
			setUserService(userService);
			context.log("User Service is set in Login servelet");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		User clientUser = new User();
		clientUser.setUsername(username);
		clientUser.setPassword(password);
		PrintWriter out = response.getWriter() ;
		try {
			if(userService.validateUser(clientUser)) {
				//out.println("<p>Dear "+ username+" Welcome to Online Shopping</p>");
				RequestDispatcher rd = request.getRequestDispatcher("Welcome");
				rd.forward(request, response);
			}else {
				out.println("<p>Sorry! Invalid UserName or Password</p>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
