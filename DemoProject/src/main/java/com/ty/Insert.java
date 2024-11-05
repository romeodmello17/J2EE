package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul";
		String username = "postgres";
		String password = "root";
		
		try {
			//step 1. load the driver
			Class.forName(driver);
			System.out.println("Driver loaded");
			
			//step 2. create a connection
	Connection conn	= DriverManager.getConnection(url, username, password);
				System.out.println("Connection is created");
			//step 3. create a statement
	Statement stm = conn.createStatement();
		System.out.println("Statement is created");
	
			//step 4. execute a query
	String query = "insert into employee values (104,'Ashuuu',5454456432)";
	stm.execute(query);
		System.out.println("Query got executed");
		
			//step 5. Close the connection
		conn.close();
		System.out.println("connection is close");
			
	
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
