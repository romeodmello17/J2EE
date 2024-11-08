package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClosingConnectionWithTryFinally {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";

		Connection con = null;

		try {
			Class.forName(driver);
			System.out.println("Driver is Loaded");

			con = DriverManager.getConnection(url);
			System.out.println("Connection is created");

			Statement stm = con.createStatement();
			System.out.println("Statement is created");

			String sql = "select * from employee order by e_d";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				System.out.println("==============Employee=============");
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				long econtact = rs.getLong(3);

				System.out.println(eid);
				System.out.println(ename);
				System.out.println(econtact);
				System.out.println("===================================");
			}
			System.out.println("Query executed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("Connection is Closed");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
