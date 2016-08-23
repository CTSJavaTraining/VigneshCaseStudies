package org.jdbcmodule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ReadFromTable {

	static final Logger logger = Logger.getLogger(ReadFromTable.class);

	protected static void selectFromDB(Connection conn) throws SQLException {
		String getdata = "SELECT * FROM brbtable";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(getdata);) {

			// Creating a normal statement

			// Executing the sql query and saving it in resultset.

			int rownum = 0;
			while (rs.next()) {
				rownum++;

				String id = rs.getString("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String fullname = rs.getString("fullname");
				String street = rs.getString("street");
				int salary = rs.getInt("salary");
				String doj = rs.getString("doj");

				logger.info("Read from database: Row: " + rownum + ": " + id + " " + firstname + " " + lastname + " "
						+ fullname + " " + street + " " + salary + " " + doj);
			}

		} catch (SQLException e) {
			logger.error(e);
		}
	}
}
