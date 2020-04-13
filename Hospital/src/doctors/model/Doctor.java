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
}
