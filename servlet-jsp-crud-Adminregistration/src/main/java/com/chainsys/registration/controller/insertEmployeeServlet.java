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
 * Servlet implementation class insertEmployee
 */
@WebServlet(name="insertEmployeeServlet" , value="/insertEmployeeServlet")
public class insertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		   response.setContentType("text/html");  
		 
		 PrintWriter out= response.getWriter();
		 
		 Employee emp = new Employee();
		
		
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		
		emp.setFullname(fullname);
		emp.setEmail(email);
		emp.setPassword(password);
		emp.setContact(contact);
		
		Employee employee = new Employee(fullname, email, password,contact); 
		
		EmployeeDao employeedao = new EmployeeDao();
		
		HttpSession session = request.getSession();
		
		
		
			boolean b=false;
			try {
				b = employeedao.Employeeinsert(employee);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		if(b) {
			session.setAttribute("succMsg", "Student saved successfuly");
			response.sendRedirect("saveemployee.jsp");
			System.out.println("Student saved successfuly");
		}
		else {
			session.setAttribute("errorMsg", "Student failed to get saved");
			response.sendRedirect("saveemployee.jsp");
			System.out.println("Student faield from getting saved");
		}
		out.close();
	}
		
		}


