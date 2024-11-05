package com.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingPreparedStatement {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		
		String url = "jdbc:postgresql://localhost:5432/home?user=postgres&password=root";
		
		String sql = "insert into emp values(?,?,?)";
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			// STEP 1. Load the Driver:
			Class.forName(driver);
			
			//Step 2. Create a Connection:
			Connection  con	= DriverManager.getConnection(url);
			
			//Step 3. Create a Statement:
			PreparedStatement pstm = con.prepareStatement(sql);
			
			int entries = sc.nextInt();
			
			for(int i = 1 ; i <= entries ; i++) {
				System.out.println("Enter details for Employee " + i + ":");
				
				System.out.println("Enter emplyoee ID:");
				int eid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter emplyoee Name:");
				String ename = sc.nextLine();
				System.out.println("Enter emplyoee Email:");
				String eemail = sc.nextLine();
				
				//setting parameter for preparestatement
				pstm.setInt(1, eid);
				pstm.setString(2, ename);
				pstm.setString(3, eemail);
				
				
				//Step 4. Execute a query:
				pstm.execute();
				
				System.out.println("Record "+i+" Inseted successfully");
			}
				
			//Step 5. Close the Connection:
			con.close();			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
