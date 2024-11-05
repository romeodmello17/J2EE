package com.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchingData {
public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/home?user=postgres&password=root";
		String sql = "select * from emp";
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url);
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			int i = 1;
			while (rs.next()) {
				System.out.println("==============Employee===============" + i);
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				String eemail = rs.getString(3);
				
				System.out.println(eid);
				System.out.println(ename);
				System.out.println(eemail);
				System.out.println("======================================");
				i++;
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
