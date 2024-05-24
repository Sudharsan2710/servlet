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

	public static Connection connectDB() {
		// connection object
		Connection connection = null;
		try {
			// returns the class object
			Class.forName("com.mysql.jdbc.Driver");
		
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Sudha@27102001");
		}

		catch (Exception message) {
			System.out.println(message);
		}
		return connection;
	}



	public static boolean Employeeinsert(Employee e) throws SQLException, ClassNotFoundException {
		boolean result = false;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = EmployeeDao.connectDB();
			String query = "insert into employeedetails" + "(fullname,email,password,contact)values + (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, e.getFullname());
			pst.setString(2, e.getEmail());
			pst.setString(3, e.getPassword());
			pst.setString(4, e.getContact());
			int i = pst.executeUpdate();
			
			if(i==1) {
				result=true;
			}
			con.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;

	}

	public static Employee getEmployeeById(int id) throws SQLException, ClassNotFoundException {

		Employee emp=null;
		List<Employee> e=new ArrayList<>();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = EmployeeDao.connectDB();

		String query = "select id,fullname,email,password,contact from employeedetails where id = ?";
		PreparedStatement pst = con.prepareStatement(query);

		pst.setInt(1, emp.getId());

		ResultSet rs = pst.executeQuery();
			
		if (rs.next()) {
			emp=new Employee();
			emp.setId(rs.getInt(1));
			emp.setFullname(rs.getString(2));
			emp.setEmail(rs.getString(3));
			emp.setPassword(rs.getString(4));
			emp.setContact(rs.getString(5));

		}
		con.close();
		return emp;
	}

	public static List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {

		List<Employee> list = new ArrayList<>();
		Employee emp=null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = EmployeeDao.connectDB();
			String query = "select * from  employeedetails";
			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				 emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setFullname(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setContact(rs.getString(5));
				list.add(emp);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public static boolean UpdateEmployee(Employee e) throws SQLException, ClassNotFoundException {
		boolean rowUpdated = false;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = EmployeeDao.connectDB();
			String query = "update employeedetails set fullname = ?, email = ?,password = ?,contact= ? where id=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, e.getFullname());
			pst.setString(2, e.getEmail());
			pst.setString(3, e.getPassword());
			pst.setString(4, e.getContact());
			pst.setInt(5, e.getId());
			int i = pst.executeUpdate();
			
			if(i==1) {
				rowUpdated=true;
			}
		}

		catch (Exception s) {
			s.printStackTrace();
		}
		return rowUpdated;

	}

	public static boolean deleteEmployee(int id) throws ClassNotFoundException {
		boolean rowDeleted = false;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = EmployeeDao.connectDB();
			String query = "delete from user where id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);

		int	rDeleted = pst.executeUpdate();
		if(rDeleted==1) {
			rowDeleted=true;
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rowDeleted;

	}

}
