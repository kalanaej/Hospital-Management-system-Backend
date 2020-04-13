package doctors.model;

import java.sql.*;

import dbconnector.DBConnect;

public class Doctor {
	
	public String insertDoctor(String docID, String hospitalName, String docName, int age, String spec, String arrive, String leave)
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
			
			String query1 = "select Name from hospital_tbl";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			
			if(rs.next()){
				hospitalName = rs.getString("Name");
			}
			
			// create a prepared statement
			String query = " insert into doctors(`ID`, `DoctorID`, `HospitalName`, `DoctorName`, `Age`, `Specialization`, `ArriveTime`, `LeaveTime`)"+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, docID);
			preparedStmt.setString(3, hospitalName);
			preparedStmt.setString(4, docName);
			preparedStmt.setInt(5, age);
			preparedStmt.setString(6, spec);
			preparedStmt.setString(7, arrive);
			preparedStmt.setString(8, leave);
			
	
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		}
		catch (Exception e)
		{
			output = "Error while inserting the doctor.";
			System.out.println(e);
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
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
					+ "<tr><th>DoctorID</th>"
					+ "<th>Item Name</th>"
					+ "<th>ItemPrice</th>"
					+ "<th>ItemDescription</th>"
					+ "<th>Update</th>"
					+ "<th>Remove</th></tr>";
			
			String query = "select * from doctors";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			
			while (rs.next())
			{
				String ID = Integer.toString(rs.getInt("ID"));
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
				
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
				+ "<td><form method=\"post\" action=\"items.jsp\">"
				+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
				+ "<input name=\"itemID\" type=\"hidden\" value=\"" + ID + "\">" 
				+ "</form></td></tr>";
			}
			
			con.close();
			
			// Complete the html table
			output += "</table>";
		}
		catch (Exception e)
		{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
}
