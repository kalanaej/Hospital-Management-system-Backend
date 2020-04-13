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
	
	
public String readHospitalDetails()  {
		
		String output = ""; 
	
	 
	  try   
	  {   
		  DBConnect db = new DBConnect();
			Connection con = null;
			con = db.connect();
	 
	 
	   if (con == null)   
	   {
		   return "Error while connecting to the database for reading.";
		   
	   } 
	   
	 
	   // Prepare the html table to be displayed    
	output = "<table border=\"1\"><tr>"
			+ "<th>MOH Code</th>"
			+ "<th>Hospital Name</th>"
			+ "<th>Email</th>"
			+ "<th>Manager name</th>"
			+ "<th>Address</th>"
			+ "<th>TelNo</th>"
			+ "<th>UPDATE</th>"
			+ "<th>REMOVE</th>"
			+ "</tr>"; 
	 
	   String query = "select * from hospital";    
	   Statement stmt = con.createStatement();    
	   ResultSet rs = stmt.executeQuery(query); 
	
	
	// iterate through the rows in the result set   
	   while (rs.next())    
	   {    
		   String hospitalID = Integer.toString(rs.getInt("hospitalID"));     
		   String MohCode = rs.getString("mohCode");     
		   String hosName = rs.getString("hospitalName");     
		   String emailAdd = rs.getString("emailAddress");  
		   String managerName = rs.getString("managerName"); 
		   String address = rs.getString("address"); 
		   String telNo = rs.getString("telephoneNo"); 
	   
	    // Add into the html table     
		   output += "<tr><td>" + MohCode + "</td>";     
		   output += "<td>" + hosName + "</td>";     
		   output += "<td>" + emailAdd + "</td>";     
		   output += "<td>" + managerName + "</td>"; 
		   output += "<td>" + address + "</td>"; 
		   output += "<td>" + telNo + "</td>"; 
	 
	    // buttons     
		   output += "<td><input name=\"btnUpdate\" type=\"button\"        "
		   		+ "value=\"Update\" class=\"btn btn-secondary\"></td>"      
				   + "<td><form method=\"post\" action=\"hospital.jsp\">"      
		   		+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"      class=\"btn btn-danger\">"     
				   + "<input name=\"hospitalID\" type=\"hidden\" value=\"" + hospitalID      + "\">" + "</form></td></tr>";    } 
	 
	   con.close(); 
	 
	   // Complete the html table    
	   output += "</table>";  
	   }   

	catch (Exception e)   
	{    
		output = "Error while reading the hospital details.";    
		System.err.println(e.getMessage());   
		
	} 
	 
	  return output;  
	  
	}
	
	
	
	
	
	
}
	