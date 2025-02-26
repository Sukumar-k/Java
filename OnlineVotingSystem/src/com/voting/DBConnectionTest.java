package com.voting;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTest {

	public static void main(String[] args) {
		
	
		String url = "jdbc:mysql://localhost:3306/ online_voting "; // Replace with your actual DB name
		String user = "root";  
		        String password = "Sonunisar@123";

		        try {
		            Connection conn = DriverManager.getConnection(url, user, password);
		            if (conn != null) {
		                System.out.println("✅ Database Connected Successfully!");
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	}

}
