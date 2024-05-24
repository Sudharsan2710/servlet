package com.chainsys.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.registration.DAO.EmployeeDao;
import com.chainsys.registration.model.Employee;

/**
 * Servlet implementation class updateEmployee
 */
@WebServlet(name = "updateEmployeeServlet", value = "/updateEmployeeServlet")
public class updateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fullname = req.getParameter("fullname");

		String email = req.getParameter("address");
		String password = req.getParameter("qualification");
		String contact = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));

		Employee employee = new Employee(id, fullname, email, password, contact);

		HttpSession session = req.getSession();

		boolean b = false;
		try {
			b = EmployeeDao.UpdateEmployee(employee);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (b) {
			session.setAttribute("succMsg", "Student updated successfuly");
			resp.sendRedirect("save-employeelist.jsp");
			System.out.println("Employee updated successfuly");
		} else {
			session.setAttribute("errorMsg", "Student failed to get update");
			resp.sendRedirect("save-employeelist.jsp");
			System.out.println("Employee failed from getting update");
		}

	}

}
