package org.shop_hibernate.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class MysqlTest {
	@Resource(name = "jdbc/MySQL_DS")
	private static DataSource dataSource;

	public static void main(String[] args) throws SQLException {
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		String str = "select * from COMMERCE";
		ResultSet rs = stmt.executeQuery(str);
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
	}

}
