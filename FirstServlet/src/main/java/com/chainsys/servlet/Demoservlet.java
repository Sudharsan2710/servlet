package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demoservlet
 */
@WebServlet(name = "DemoServlet", urlPatterns = { "/DemoServlet" })
public class Demoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fullName = request.getParameter("fullname");
		
		String e_mail = request.getParameter("email");
		String password1 = request.getParameter("password");
		String confirm_password = request.getParameter("confirm-password");
		String date = request.getParameter("birthdate");
		String gender = request.getParameter("gender");
		PrintWriter out = response.getWriter();
		
		
		out.println(fullName);
		out.println(e_mail);
		out.println(password1);
		out.println(confirm_password);
		out.println(date);
		out.println(gender);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
