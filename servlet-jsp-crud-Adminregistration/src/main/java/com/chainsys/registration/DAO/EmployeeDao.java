package com.chainsys.registration.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.registration.model.Employee;

public class EmployeeDao {
	
	String url = "jdbc:mysql://localhost:3306/employee";
	String user = "root";
	String password1 = "Sudha@27102001";
	Employee emp = new Employee();
	

	private static final String InsertEmployee = "insert into employeedetails"
			+ "(fullname,email,password,contact)values + (?,?,?,?)";
	private static final String SelectEmployeebyID = "select id,fullname,email,password,contact from employeedetails where id = ?";
	private static final String SelectAllEmployee = "select * from  employeedetails";
	private static final String UpdateEmployee = "update employeedetails set fullname = ?, email = ?,password = ?,contact= ?";
	private static final String DeleteEmployee = "delete from user where id = ?";
	
	
	
	
	protected Connection getConnection(){
		Connection con=null;
		try {
		

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password1);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	public void Employeeinsert(Employee e) throws SQLException, ClassNotFoundException {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, password1);

			PreparedStatement pst = con.prepareStatement(InsertEmployee);

			pst.setString(1, e.getFullname());
			pst.setString(2, e.getEmail());
			pst.setString(3, e.getPassword());
			pst.setString(4, e.getContact());
			pst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}




	public Employee Selectemployeebyid(int id) throws SQLException, ClassNotFoundException {
		Employee ey = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, password1);

			PreparedStatement pst = con.prepareStatement(SelectEmployeebyID);
			
			pst.setInt(1, emp.getId());
			System.out.println(pst);

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String contact = rs.getString("contact");
				ey= new Employee(fullname,email,password,contact); 
						}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ey;

	}
	
	
	
	public List<Employee> SelectAllEmployees() throws SQLException, ClassNotFoundException {
		Employee ey = null;
		List<Employee> alist = new ArrayList<>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, password1);

			PreparedStatement pst = con.prepareStatement(SelectEmployeebyID);
			
		
			System.out.println(pst);

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String contact = rs.getString("contact");
				alist.add(new Employee(fullname,email,password,contact)); 
						
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return alist;
	}
	public boolean UpdateEmployee(Employee e)
			throws SQLException, ClassNotFoundException {
		boolean rowUpdated = false;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, password1);

			PreparedStatement pst = con.prepareStatement(UpdateEmployee);
			
			pst.setString(2, emp.getFullname());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPassword());
			pst.setString(5, emp.getContact());
			rowUpdated=pst.executeUpdate()>0;
		}
		
		catch(Exception s) {
			s.printStackTrace();
		}
		return rowUpdated;
		
	}
	
	public  boolean deleteEmployee(int id) throws ClassNotFoundException {
		boolean rowDeleted = false;
		try {
			
//			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, password1);
			
			PreparedStatement pst = con.prepareStatement(DeleteEmployee);
			pst.setInt(1, id);
			
			rowDeleted=pst.executeUpdate() > 0;
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rowDeleted;

		

	}
	
}
		
		
		

	
	
		

	
	
	
	
	
	





