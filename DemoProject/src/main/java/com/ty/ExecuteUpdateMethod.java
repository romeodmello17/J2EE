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

			String sql1 = "select * from employee order by e_id";

			String sql2 = "insert into employee values(109,'Penga',76544343)";

			String sql3 = "update employee set e_contact = 69696969 where e_name = 'Penga'";

			// int update1 = stm.executeUpdate(sql1);
			// System.out.println(update1); A result was returned when none was expected.

			// int update2 = stm.executeUpdate(sql2);
			// System.out.println(update2); //1 row affected

			int update3 = stm.executeUpdate(sql3);
			System.out.println(update3); // 5 rows affected

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
