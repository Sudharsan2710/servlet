package com.chainsys.registration.DAO;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.registration.model.Employee;

public class EmployeeDao{
		
	    public boolean Employeeregister(Employee e) throws SQLException, ClassNotFoundException {
	    	boolean flag=false;
	    	
	    	
	    	try {
	    	String url="jdbc:mysql://localhost:3306/employee";
    		String user = "root";
    		String password="Sudha@27102001";
    	
    		Class.forName("com.mysql.cj.jdbc.Driver");
	    
	    		 Connection con=DriverManager.getConnection(url,user,password);
	    		 System.out.println(e.getFullname());
	    		 System.out.println(con);
			
				String query = "insert into employeedetails(fullname,email,password,contact)values(?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(query);
				
				pst.setString(1, e.getFullname());
				pst.setString(2, e.getEmail());
				pst.setString(3, e.getPassword());
				pst.setString(4, e.getContact());
				pst.executeUpdate();
				flag=true;
				
				
				

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	    	return flag;
	    	
	    }
}

			

		

	    	
	   

