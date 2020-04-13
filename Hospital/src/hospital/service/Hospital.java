package hospital.service;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconnector.DBConnect;

public class Hospital {
	

	
	
	public String insertHoapitalDet(String MOHcode, String Hos_name, String Hos_email, String Hos_managername,  String Hos_address, String Hos_phoneNumber )  
	{   
		String output = ""; 
	
	 
	  try   
	  {    
		  DBConnect db = new DBConnect();
			Connection con = null;
			con = db.connect();
	  
	 
		  if (con == null)    
	   {
		   return "Error while connecting to the database for inserting.";
		   
	   } 
	 
	   // create a prepared statement    
	   String query = " insert into hospital "
	   		+ "(`hospitalID`,`mohCode`,`hospitalName`,`emailAddress`,`managerName`,`address`,`telephoneNo`)"     
			   + " values (?, ?, ?, ?, ?, ?, ?)"; 
	 
	   PreparedStatement preparedStmt = con.prepareStatement(query); 
	   
	 
	   // binding values   
			preparedStmt.setInt(1, 0);    
			preparedStmt.setString(2, MOHcode);    
			preparedStmt.setString(3, Hos_name);    
			preparedStmt.setString(4, Hos_email);
			preparedStmt.setString(5, Hos_managername); 
			preparedStmt.setString(6, Hos_address);
			preparedStmt.setString(7, Hos_phoneNumber);
			
			// execute the statement    
			preparedStmt.execute();    
			con.close();  
			
			output = "Inserted successfully"; 
			
	  }
	  catch (Exception e)   
	  {    
		  output = "Error while inserting the hospital details.";    
		  System.err.println(e.getMessage());   
		  
	  }
	return output; 
	  }
	
	
}
	