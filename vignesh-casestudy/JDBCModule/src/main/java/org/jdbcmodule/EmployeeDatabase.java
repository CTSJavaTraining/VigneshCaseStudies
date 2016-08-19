package org.jdbcmodule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDatabase {
	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Class.forName("com.mysql.jdbc.Driver");

		String connectionUrl = "jdbc:mysql://localhost:3306/vigneshbrbdb";
		String connectionUser = "root";
		String connectionPassword = "CDPff123";

		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		stmt = conn.createStatement();

		rs = stmt.executeQuery("SELECT * FROM brbtable");

		String sql = "INSERT INTO brbtable (id,firstname,lastname,fullname,salary,street,doj) "
				+ "VALUES (141212, \"Ganesh\", \"Ganapathy\", \"GG\", 30000, \"Senoy\", \"21-Jul-1992\")";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.execute();

		// stmt.execute(sql);
		System.out.println("Inserted");

		String sqldel = "DELETE FROM brbtable where id=125555";
		PreparedStatement pstmtdel = conn.prepareStatement(sqldel);
		pstmtdel.execute();

		try {
			while (rs.next()) {
				String id = rs.getString("firstname");
				System.out.println("id is " + id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
