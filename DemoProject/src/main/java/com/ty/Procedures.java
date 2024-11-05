package com.ty;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedures {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url);
			
			String sql = "call procedure_name(?,?,?)";
			CallableStatement cstm = con.prepareCall(sql);
			
			cstm.setInt(1, 109);
			cstm.setString(2, "Sharvari" );
			cstm.setString(3, "naral@gmail.com");
			
			cstm.execute();
			
			con.close();
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
