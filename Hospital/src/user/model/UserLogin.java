package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconnector.DBConnect;

public class UserLogin {

	public String validateLogin(String userName, String password)
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
			
			String query1 = "select Username, Password from users";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			
			while(rs.next()){
				String un = rs.getString("Username");
				String pass = rs.getString("Password");
				
				if(userName == un && password == pass)
				{
					System.out.println("Successfully logged in");
				}
			}
			
			/*// create a prepared statement
			String query = " insert into doctors(`DoctorID`, `HospitalName`, `DoctorName`, `Age`, `Specialization`, `ArriveTime`, `LeaveTime`)"+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);*/
			
			
				
			/*// binding values
			preparedStmt.setString(1, docID);
			preparedStmt.setString(2, hospitalName);
			
			// execute the statement
			preparedStmt.execute();
			con.close();*/
			//output = "Inserted successfully";
		}
		catch (Exception e)
		{
			output = "Error while inserting the doctor.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
}
