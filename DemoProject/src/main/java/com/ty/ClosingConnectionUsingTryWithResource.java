package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClosingConnectionUsingTryWithResource {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";

		try {
			Class.forName(driver);
			System.out.println("Driver is Loaded");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(url);) {

			Statement stm = con.createStatement();
			System.out.println("Statement is created");

			String sql = "select * from employee order by e_id";
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

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
