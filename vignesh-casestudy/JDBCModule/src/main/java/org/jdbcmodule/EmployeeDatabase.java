package org.jdbcmodule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * This class has main method to perfrom CRUD operation in mySQL and perform
 * transaction management
 */
public class EmployeeDatabase {
	private static final Logger logger = Logger.getLogger(EmployeeDatabase.class);

	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		// Connection parameters
		String connectionUrl = "jdbc:mysql://localhost:3306/vigneshbrbdb";
		String connectionUser = "root";
		String connectionPassword = "CDPff123";
		String driverClass = "com.mysql.jdbc.Driver";

		try (Connection conn = getConnection(driverClass, connectionUrl, connectionUser, connectionPassword)) {
			
			// ReadFromTable.selectFromDB(conn);
			InsertIntoDB.insertor(conn);
			// DeleteFromDB.deletor(conn);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static Connection getConnection(String driverClass, String connectionUrl, String connectionUser,
			String connectionPassword) throws ClassNotFoundException, SQLException {

		Class.forName(driverClass);

		Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

		logger.info("Connection is established");
		return conn;
	}
}
