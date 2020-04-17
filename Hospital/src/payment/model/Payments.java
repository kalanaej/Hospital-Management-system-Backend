package payment.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconnector.DBConnect;

public class Payments {

	public String validatePayment(String cardNumber, String cvv) 
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
				
			String query1 = "select CardNumber, CVV, Credits from bank";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			
			double charge = 1500.00;
				
			while(rs.next())
			{
				String card = rs.getString("CardNumber");
				String cv = rs.getString("CVV");
				double available = rs.getDouble("Credits");
					
				if(cardNumber.equals(card) && cvv.equals(cv))
				{
					if(charge > available)
					{
						return "Insufficient balance. Available balance is " +available;
					}
					else
					{
						available = available - charge;
						
						String query = "UPDATE bank SET Credits = '"+available+"' where CardNumber = '"+cardNumber+"' and CVV = '"+cvv+"'";
						PreparedStatement preparedStmt = con.prepareStatement(query);
						preparedStmt.execute();
						
						return "Payment is successfull. Available balance is " +available;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return "Card Number or cvv incorrect";
	}
}
