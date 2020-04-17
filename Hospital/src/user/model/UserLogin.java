package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconnector.DBConnect;

public class UserLogin {

	public String validateLogin(String userName, String password) 
	{
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
				
			while(rs.next())
			{
				String un = rs.getString("Username");
				String pass = rs.getString("Password");
					
				if(userName.equals(un) && password.equals(pass))
				{
					return "Welcome "+ userName;
				}
				else if(userName.equals("admin") && password.equals("admin"))
				{
					return "Welcome Admin";
				}
			}
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return "Username or password incorrect";
	}
	
	public String readUser(String userName, String password)
	{
		String output = "";
		
//		String userName = "kalanaej"; 
//		String password = "kalana123";
		
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
					+ "<tr><th>PatientID</th>"
					+ "<th>Email</th>"
					+ "<th>Username</th>"
					+ "<th>Password</th>"
					+ "<th>Age</th>"
					+ "<th>Address</th>"
					+ "<th>Phone Number</th>"
					+ "<th>Update</th>"
					+ "<th>Remove</th></tr>";
			
			String query1 = "select Username, Password from users";
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(query1);
			
			// iterate through the rows in the result set
			while (rs1.next())
			{
				String un = rs1.getString("Username");
				String pass = rs1.getString("Password");
					
				if(userName.equals(un) && password.equals(pass))
				{
					String query = "select * from users where Username = '"+userName+"' and Password = '"+password+"'";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					
					while (rs.next()) 
					{
						String patientID = rs.getString("PatientID");
						String email = rs.getString("Email");
						String username = rs.getString("Username");
						String passwrd = rs.getString("Password");
						String age = Integer.toString(rs.getInt("Age"));
						String address = rs.getString("Address");
						String phoneNo = Integer.toString(rs.getInt("PhoneNo"));
					
						// Add into the html table
						output += "<tr><td>" + patientID + "</td>";
						output += "<td>" + email + "</td>";
						output += "<td>" + username + "</td>";
						output += "<td>" + passwrd + "</td>";
						output += "<td>" + age + "</td>";
						output += "<td>" + address + "</td>";
						output += "<td>" + phoneNo + "</td>";
						
						// buttons
						output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
						+ "<input name=\"ID\" type=\"hidden\" value=\"" + patientID + "\">" 
						+ "</form></td></tr>";
					}
					con.close();
					output += "</table>";
					return output;
				}
				else if(userName.equals("admin") && password.equals("admin"))
				{
					String query = "select * from users";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					
					while (rs.next()) 
					{
						String patientID = rs.getString("PatientID");
						String email = rs.getString("Email");
						String username = rs.getString("Username");
						String passwrd = rs.getString("Password");
						String age = Integer.toString(rs.getInt("Age"));
						String address = rs.getString("Address");
						String phoneNo = Integer.toString(rs.getInt("PhoneNo"));
						
						// Add into the html table
						output += "<tr><td>" + patientID + "</td>";
						output += "<td>" + email + "</td>";
						output += "<td>" + username + "</td>";
						output += "<td>" + passwrd + "</td>";
						output += "<td>" + age + "</td>";
						output += "<td>" + address + "</td>";
						output += "<td>" + phoneNo + "</td>";
						
						// buttons
						output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
						+ "<input name=\"ID\" type=\"hidden\" value=\"" + patientID + "\">" 
						+ "</form></td></tr>";
					}
					con.close();
					output += "</table>";
					return output;
				}
			}
			
			con.close();
			
			// Complete the html table
			output = "Username or password incorrect";
		}
		catch (Exception e)
		{
			output = "Error while reading the user.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
}