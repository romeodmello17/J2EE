package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQueryMethod {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			Statement stm = con.createStatement();

			String sql1 = "select * from employee order by e_id";

			String sql2 = "insert into employee values(100,'Penga',2345533)";

			ResultSet rs = stm.executeQuery(sql1);
			// System.out.println(rs);
			while (rs.next()) {
				System.out.println("==================Employee===============");
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				long econtact = rs.getLong(3);

				System.out.println(eid);
				System.out.println(ename);
				System.out.println(econtact);
				System.out.println("=========================================");
			}

			// ResultSet rs1 = stm.executeQuery(sql2); No results were returned by the
			// query.

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
