package appointments.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconnector.DBConnect;

public class Appointments {

	public String insertAppointments(String uname, String dname, String hname, String mdate, String ptype) {
		String output = "";
		try {
			DBConnect db = new DBConnect();
			Connection con = null;
			con = db.connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into appointments(`token_number`,`username`,`doctor_name`,`hospital_name`,`date`,`payment_type`)"
					+ " values (?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, uname);
			preparedStmt.setString(3, dname);
			preparedStmt.setString(4, hname);
			preparedStmt.setDate(5, java.sql.Date.valueOf(mdate));
			preparedStmt.setString(6, ptype);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";

		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readAppointments() {
		String output = "";
		try {
			DBConnect db = new DBConnect();
			Connection con = null;
			con = db.connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr>" + "<th>Token Number</th>" + "<th>User Name</th>"
					+ "<th>Doctor Name</th>" + "<th>Hospital Name</th>" + "<th>Date</th>" + "<th>Payment Type</th>"
					+ "</tr>";

			String query = "select * from appointments";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String token_number = Integer.toString(rs.getInt("token_number"));
				String username = rs.getString("username");
				String doctor_name = rs.getString("doctor_name");
				String hospital_name = rs.getString("hospital_name");
				Date date = rs.getDate("date");
				String payment_type = rs.getString("payment_type");

				// Add into the html table
				output += "<tr><td>" + token_number + "</td>";
				output += "<td>" + username + "</td>";
				output += "<td>" + doctor_name + "</td>";
				output += "<td>" + hospital_name + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + payment_type + "</td>";

				output += "</tr>";
			}
			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateAppointments(String tnumber, String uname, String dname, String hname, String mdate,
			String ptype) {

		String output = "";

		try {
			DBConnect db = new DBConnect();
			Connection con = null;
			con = db.connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE appointments SET username=?,doctor_name=?,hospital_name=?,date=?,payment_type=? WHERE token_number=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, uname);
			preparedStmt.setString(2, dname);
			preparedStmt.setString(3, hname);
			preparedStmt.setDate(4, java.sql.Date.valueOf(mdate));
			preparedStmt.setString(5, ptype);
			preparedStmt.setInt(6, Integer.parseInt(tnumber));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteAppointments(String tnumber) {

		String output = "";

		try {
			DBConnect db = new DBConnect();
			Connection con = null;
			con = db.connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from appointments where token_number=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(tnumber));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
