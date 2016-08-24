package org.jdbcmodule;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * This class has main method to perform CRUD operation in mySQL and perform
 * transaction management
 */
public class EmployeeDatabase {

	private static final Logger logger = Logger.getLogger(EmployeeDatabase.class);

	private EmployeeDatabase() {
	}

	/**
	 * Main Method to perform CRUD Operation in DB
	 * 
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		logger.info("-----------------Application Begins here--------------");
		// Connection parameters
		String connectionUrl = "jdbc:mysql://localhost:3306/vigneshbrbdb";
		String connectionUser = "root";
		String connectionPassword = "CDPff123";
		String driverClass = "com.mysql.jdbc.Driver";

		try (Connection conn = CRUDOperation.getConnection(driverClass, connectionUrl, connectionUser,
				connectionPassword)) {

			CRUDOperation.insertor(conn);
			CRUDOperation.selectFromDB(conn);
			CRUDOperation.deletor(conn);
			CRUDOperation.selectFromDB(conn);
			CRUDOperation.checkTransactionManagement(conn);

		} catch (Exception e) {
			logger.error(e);
		}
	}

}
