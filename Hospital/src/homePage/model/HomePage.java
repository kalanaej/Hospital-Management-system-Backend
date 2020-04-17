package homePage.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconnector.DBConnect;

public class HomePage {

	public String readDoctors()
	{
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
			output = "<table border=\"1\">"
					+ "<tr><th>Doctor ID</th>"
					+ "<th>Hospital Name</th>"
					+ "<th>Doctor Name</th>"
					+ "<th>Age</th>"
					+ "<th>Specialization</th>"
					+ "<th>ArriveTime</th>"
					+ "<th>LeaveTime</th></tr>";
			
			String query = "select * from doctors";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			
			while (rs.next())
			{
				String docID = rs.getString("DoctorID");
				String hospitalName = rs.getString("HospitalName");
				String docName = rs.getString("DoctorName");
				String age = Integer.toString(rs.getInt("Age"));
				String spec = rs.getString("Specialization");
				String arrive = rs.getString("ArriveTime");
				String leave = rs.getString("LeaveTime");
				
				// Add into the html table
				output += "<tr><td>" + docID + "</td>";
				output += "<td>" + hospitalName + "</td>";
				output += "<td>" + docName + "</td>";
				output += "<td>" + age + "</td>";
				output += "<td>" + spec + "</td>";
				output += "<td>" + arrive + "</td>";
				output += "<td>" + leave + "</td>";
				
			}
			
			con.close();
			
			// Complete the html table
			output += "</table>";
		}
		catch (Exception e)
		{
			output = "Error while reading the doctor.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public String readHospitals()  {
		
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
					+ "<th>TelNo</th></tr>"; 
	 
		   String query = "select * from hospital";    
		   Statement stmt = con.createStatement();    
		   ResultSet rs = stmt.executeQuery(query); 
		
		
		   // iterate through the rows in the result set   
		   while (rs.next())    
		   {        
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
		 
			   	} 
		 
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
