package com.chainsys.registration.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.registration.DAO.EmployeeDao;
import com.chainsys.registration.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao employeedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
      this.employeedao= new EmployeeDao(); 
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	
		
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getServletPath();
		switch (action) {
		case "/new":
		
			break;
		case "/insert":
			insertEmployee(request,response);						
			break;
		case "/delete":
			deleteEmployee(request,response);
			break;
		case"/edit":
			try {
				showform(request,response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/update":
			updateEmployee(request,response);
			break;
			
		default:
			listUser(request,response);
			break;
		}
	}

		
		private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			int id = Integer.parseInt(request.getParameter("id"));
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String contact = request.getParameter("contact");
			
			Employee es = new Employee(fullname,email,password,contact);
			try {
				employeedao.UpdateEmployee(es);
				try {
					response.sendRedirect("list");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

		private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			int id = Integer.parseInt(request.getParameter("id"));
			
				try {
					employeedao.deleteEmployee(id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					response.sendRedirect("list");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
	}

	private void showform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = employeedao.Selectemployeebyid(id);

		request.setAttribute("Employee", existingEmployee);

		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);

	}
		
		private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				doGet(request,response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String contact = request.getParameter("contact");
			
			
			Employee employee = new Employee(fullname,email,password,contact);
			try {
				employeedao.Employeeinsert(employee);
				response.sendRedirect("list");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Employee> listUser ;
			try {
				listUser = employeedao.SelectAllEmployees();
				request.setAttribute("listUser", listUser);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
			dispatcher.forward(request, response);
	}
}
