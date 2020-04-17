package user.model;

import java.sql.*;

import dbconnector.DBConnect;

public class UserRegister {

	public String insertUser(String email, String username, String password, int age, String address, int phoneNo)
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
			String query = " insert into users(`PatientID`, `Email`, `Username`, `Password`, `Age`, `Address`, `PhoneNo`)"+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
				
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, email);
			preparedStmt.setString(3, username);
			preparedStmt.setString(4, password);
			preparedStmt.setInt(5, age);
			preparedStmt.setString(6, address);
			preparedStmt.setInt(7, phoneNo);
			
			
	
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Registration successfully";
		}
		catch (Exception e)
		{
			output = "Error while inserting the user.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
}
