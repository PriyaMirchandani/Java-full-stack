package com.zensar.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/checkuser")
public class LoginController extends HttpServlet {
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
			ServletContext context=config.getServletContext();
			String driverClassname=context.getInitParameter("jdbcDriver");
			String dbUrl=context.getInitParameter("jdbcUrl");
			String dbUsername=context.getInitParameter("dbUser");
			String dbPassword= context.getInitParameter("dbPassword");
			
			try {
				//load jdbc driver class

					Class.forName(driverClassname);
					context.log("jdbc driver is loaded successfully");
					Connection con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
					context.log("mysql database connection  is established successfully");
					UserDao userDao=new UserDaoImpl();
					((UserDaoImpl)userDao).setConnection(con);
					System.out.println(userDao);
					UserService userService=new UserServiceImpl();
					System.out.println(userService);
					((UserServiceImpl)userService).setUserDao(userDao);
					setUserService(userService);
					System.out.println(userService);
					context.log("user service is set in login servlet");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
			
			
			
		}

		

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			PrintWriter out=response.getWriter();
			String username=request.getParameter("username");
			String password=request.getParameter("passwd");
			User clientUser=new User();
			clientUser.setUsername(username);
			clientUser.setPassword(password);
			System.out.println(userService);
			
		try {
			if(userService.validateUser(clientUser))
				{
				//out.print("<p>dear " + username + " welcome to online shopping </p>");	
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
				
				}
			
			else
			{
					out.println("<p> sorry! Invalid username or password </p>");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
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
