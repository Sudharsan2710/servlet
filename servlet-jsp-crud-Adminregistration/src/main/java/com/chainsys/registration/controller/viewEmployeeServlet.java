package com.chainsys.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.registration.DAO.EmployeeDao;
import com.chainsys.registration.model.Employee;

/**
 * Servlet implementation class viewEmployeeServlet
 */
@WebServlet(name = "viewEmployeeServlet", value = "/viewEmployeeServlet")
public class viewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public viewEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		processRequest(request, response);
		PrintWriter out = response.getWriter();

		
		out.println("<a href='employee-list.jsp'>Add employee</a>");

		out.print("<h1> Employee Table: </h1>");
		List<Employee> list = null;
		try {
			list = EmployeeDao.getAllEmployees();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print("<table border='1' cellpadding='4' width='80%'>");
		out.print(
				"<tr><th>Id</th><th>FullName</th><th>Email</th><th>Password</th><th>Contact</th><th>Edit</th><th>Delete</th></tr>");

		for (Employee e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getFullname() + "</td><td>" + e.getEmail() + "</td><td>"
					+ e.getPassword() + "</td><td>" + e.getContact() + "</td><td><a href='updateEmployeeServlet?id="
					+ e.getId() + "'>edit</a>" + "</td><td><a href='deleteEmployeeServlet?id=" + e.getId()
					+ "'>delete</a></td></tr>");
		}
		out.print("</table>");

	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
