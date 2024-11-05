package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdateMethod {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url);
			
			Statement stm = con.createStatement();
			
			String sql1 = "select * from employee";
			
			String sql2 = "insert into employee values(102,'Rutik',876542345)";
			
			String sql3 = "update employee set e_contact=9999999 where e_name = 'Rahul'";
//			int update = stm.executeUpdate(sql1);
//			System.out.println(update); A result was returned when none was expected.
			
//			int update2 = stm.executeUpdate(sql2);
//			System.out.println(update2); // 1 row affected
			
			int update3 = stm.executeUpdate(sql3);
			System.out.println(update3); //2 rows affected
			
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
