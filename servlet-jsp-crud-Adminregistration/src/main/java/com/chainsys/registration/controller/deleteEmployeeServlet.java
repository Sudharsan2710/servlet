package com.chainsys.registration.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.registration.DAO.EmployeeDao;

/**
 * Servlet implementation class deleteEmployee
 */
@WebServlet(name = "deleteEmployeeServlet", value = "/deleteEmployeeServlet")
public class deleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteEmployeeServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeDao employeedao = new EmployeeDao();
		boolean b = false;
		try {
			b = EmployeeDao.deleteEmployee(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		if (b) {
			session.setAttribute("succMsg", "Employee deleted successfuly");
			response.sendRedirect("index.jsp");
			System.out.println("Employee deleted successfuly");
		} else {
			session.setAttribute("errorMsg", "Employee failed to get delete");
			response.sendRedirect("index.jsp");
			System.out.println("Employee failed from getting deleted");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
