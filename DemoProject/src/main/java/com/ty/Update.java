package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";

		try {
			// Step 1. load the driver
			Class.forName(driver);
			System.out.println("Driver is loaded");

			// Step 2. create a connection
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connection is created");

			// Step 3. create a statement
			Statement stm = conn.createStatement();
			System.out.println("Statement is created");

			// Step 4. Execute a query
			String sql = "UPDATE employee SET empname='Rohit' WHERE empid=102";
			stm.execute(sql);
			System.out.println("Query is executed");

			// Step 5. Close the connection
			conn.close();
			System.out.println("Connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
