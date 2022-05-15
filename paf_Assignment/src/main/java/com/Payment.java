package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {
	private static final String Payment_id = null;

			//A common method to connect to the DB
			private Connection connect(){ 
							Connection con = null; 							
							try{ 
									Class.forName("com.mysql.jdbc.Driver"); 
	 
									//Provide the correct details: DBServer/DBName, username, password 
									con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pafprojecteletricity", "root", ""); 
							} 
							catch (Exception e) {
								e.printStackTrace();
								} 
							
							return con; 
				} 
			
			
	public String readpayment() 
			{ 
				String output = ""; 
				try
				{ 
					Connection con = connect(); 
			 if (con == null) 
			 { 
			 return "Error while connecting to the database for reading."; 
			 } 
			 // Prepare the html table to be displayed
			 output = "<table border=\"1\" class=\"table\"><tr>"
			 		+ "<th>Customer ID</th>"
			 		+ "<th>Customer Name</th>"
			 		+ "<th>Date</th>"
			 		+ "<th>Amount</th>"
			 		+ "<th>Description</th>"
			 		+ "<th>Update</th>"
			 		+ "<th>Remove</th></tr>"; 
			
			 String query = "select * from paymentapi"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
			 String Payment_id = Integer.toString(rs.getInt("Payment_id")); 
			 String Payment_customer_id = rs.getString("Payment_customer_id"); 
			 String Payment_customer_name = rs.getString("Payment_customer_name"); 
			 String Payment_date = rs.getString("Payment_date");
			 String Payment_amount = rs.getString("Payment_amount"); 
			 String Payment_description = rs.getString("Payment_description"); 
			 // Add into the html table
			 output += "<tr><td><input id='hidPayment_idUpdate' name='hidPayment_customer_idUpdate' type='hidden' value='"+Payment_id+"'>"+Payment_customer_id+"</td>"; 
			 output += "<td>" + Payment_customer_name + "</td>"; 
			 output += "<td>" + Payment_date + "</td>"; 
			 output += "<td>" + Payment_amount + "</td>"; 
			 output += "<td>" + Payment_description + "</td>";
			 // buttons
			 output += "<td><input name='btnUpdate' type='button' value='Update' "
					 + "class='btnUpdate btn btn-secondary' data-bid='" + Payment_id + "'></td>"
					 + "<td><input name='btnRemove' type='button' value='Remove' "
					 + "class='btnRemove btn btn-danger' data-bid='" + Payment_id + "'></td></tr>"; 
			 
			 } 
			 con.close(); 
			 // Complete the html table
			 output += "</table>"; 
			 } 
			 
			catch (Exception e) 
			 { 
			 output = "Error while reading the payment."; 
			 System.err.println(e.getMessage()); 
			 } 
			return output; 
			}		
	
public String insertPayment(String Payment_customer_id, String Payment_customer_name, String Payment_date, String Payment_amount, String Payment_description){ 
				
				String output = ""; 
				
				try
				{ 
					Connection con = connect(); 
					
					if (con == null) 
					{
						return "Error while connecting to the database for inserting."; 
						
					} 
					// create a prepared statement
					
					String query = " insert into paymentapi(String Payment_customer_id, String Payment_customer_name, String Payment_date, String Payment_amount, String Payment_description)" + " values ( ?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = con.prepareStatement(query); 
					// binding values
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, Payment_customer_id);
					preparedStmt.setString(3, Payment_customer_name); 
					preparedStmt.setString(4, Payment_date); 
					preparedStmt.setString(5, Payment_amount);
					preparedStmt.setString(6, Payment_description); 
					// execute the statement

					preparedStmt.execute(); 
					con.close(); 
					
					String newPayment = readpayment(); 
					output = "{\"status\":\"success\",\"data\":\""+newPayment+"\"}"; 
				} 
				
				catch (Exception e) 
				{ 
					output = "{\"status\":\"error\", \"data\":\"Error while inserting the Payment.\"}"; 
					System.err.println(e.getMessage()); 
				} 
				return output; 
		}
			
	public String updatePayment(String Payment_customer_id, String Payment_customer_name, String Payment_date, String Payment_amount, String Payment_description) {
				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for updating.";
					}

					// create a prepared statement
					String query = "UPDATE paymentapi set Payment_customer_id=?,Payment_customer_name=?,Payment_date=?,Payment_amount=?,Payment_description=?  WHERE Payment_id=?";

					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					
										
					preparedStmt.setString(1, Payment_customer_id);
					preparedStmt.setString(2, Payment_customer_name); 
					preparedStmt.setString(3, Payment_date); 
					preparedStmt.setString(4, Payment_amount);
					preparedStmt.setString(5, Payment_description);
					preparedStmt.setInt(6, Integer.parseInt(Payment_id));
					// execute the statement
					preparedStmt.execute();
					con.close();

					String newPayment = readpayment(); 
					output = "{\"status\":\"success\",\"data\":\""+newPayment+"\"}"; 
				
				} catch (Exception e) {
					output = "{\"status\":\"error\", \"data\":\"Error while updating the Payment.\"}";
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			public String deletePayment(String Payment_id) {
				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}

					// create a prepared statement
					String query = "delete from paymentapi where Payment_id =?";

					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					preparedStmt.setInt(1, Integer.parseInt(Payment_id));

					// execute the statement
					preparedStmt.execute();
					con.close();

					String newPayment = readpayment(); 
					output = "{\"status\":\"success\",\"data\":\""+newPayment+"\"}"; 
				
				} catch (Exception e) {
					output = "{\"status\":\"error\", \"data\":\"Error while delete the Payment.\"}";
					System.err.println(e.getMessage());
				}

				return output;
			}
			
}