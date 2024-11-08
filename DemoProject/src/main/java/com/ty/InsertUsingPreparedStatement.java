package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsingPreparedStatement {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			String sql = "insert into employee values(?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);

			pstm.setInt(1, 106);
			pstm.setString(2, "Nikhil");
			pstm.setLong(3, 87654356L);

			pstm.execute();

			con.close();

			System.out.println("Executed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
