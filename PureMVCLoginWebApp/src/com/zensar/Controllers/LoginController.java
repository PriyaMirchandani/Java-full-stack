package com.zensar.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.models.LoginBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/checkuser")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieving request parameter values
		String username=request.getParameter("username");
		String password=request.getParameter("passwd");
		//instantiate model
		LoginBean ob=new LoginBean();
		
		//set properties of model using request data
		ob.setUsername(username);
		ob.setPassword(password);
		PrintWriter out=response.getWriter();
		//invoke business logic of model
		
		if(ob.validateUser())
		{
			RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request,response);
	    }
		else
		{
		out.println("sorry! Invalid Username/Password");
		RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
		rd.include(request,response);
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
