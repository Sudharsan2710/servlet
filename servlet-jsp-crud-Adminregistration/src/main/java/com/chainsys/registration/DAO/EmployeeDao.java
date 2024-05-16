package com.chainsys.registration.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.registration.model.Employee;

public class EmployeeDao{
		
	    public int Employeeregister(Employee e) throws SQLException {
	    	int result=0;
	    	try {
	    	String url="jdbc:mysql://localhost:3306/employee";
    		String user = "root";
    		String password="Sudha@27102001";
    	
    		
	    
	    		 Connection con=DriverManager.getConnection(url,user,password);
	 	    
			
				String query = "insert into employeedetails(id,fullname,email,password,contact)values(?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, 1);
				pst.setString(2, e.getFullname());
				pst.setString(3, e.getEmail());
				pst.setString(4, e.getPassword());
				pst.setString(5, e.getContact());
				System.out.println(pst);
				result= pst.executeUpdate();
				

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	    	return result ;
	    	
	    }
}

			

		

	    	
	   

