package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExectueMethod {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			Statement stm = con.createStatement();

			String sql1 = "select * from employee";
			String sql2 = "insert into employee values(103,'Penga',2233445)";

			boolean res1 = stm.execute(sql1);
			System.out.println(res1); // true

			boolean res2 = stm.execute(sql2);
			System.out.println(res2); // false

			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
