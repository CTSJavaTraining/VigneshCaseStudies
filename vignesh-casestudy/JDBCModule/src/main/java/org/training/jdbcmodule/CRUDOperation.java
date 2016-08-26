package org.training.jdbcmodule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * Perform CRUD Operation in DB
 * 
 * @author 447482
 *
 */
public class CRUDOperation {

	private static final Logger logger = Logger.getLogger(CRUDOperation.class);

	private CRUDOperation() {
	}

	protected static Connection getConnection(String driverClass, String connectionUrl, String connectionUser,
			String connectionPassword) throws ClassNotFoundException {

		Class.forName(driverClass);

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		} catch (SQLException e) {
			logger.error(e);
		}

		logger.info("Method getConnection -- Connection is established");
		return conn;
	}

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

				logger.info("Method: selectFromDB -- Read inserted data from database: Row: " + rownum + ": " + id + " "
						+ firstname + " " + lastname + " " + fullname + " " + street + " " + salary + " " + doj);
			}

		} catch (SQLException e) {
			logger.error("Method selectFromDB " + e);
		}
	}

	protected static void insertor(Connection conn) throws SQLException {

		// Inserting into DB using prepared statement

		// conn.prepareStatement is used to send parameterized statement to DB

		String sql = "INSERT INTO brbtable (id,firstname,lastname,fullname,salary,street,doj) "
				+ "VALUES(?,?,?,?,?,?,?)";
		conn.setAutoCommit(false);

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// Setting parameters to the prepared statement
			pstmt.setInt(1, 1);
			pstmt.setString(2, "A");
			pstmt.setString(3, "B");
			pstmt.setString(4, "A B");
			pstmt.setInt(5, 20000);
			pstmt.setString(6, "First Street");
			pstmt.setString(7, "28-Jul-1990");

			pstmt.execute();

			// Setting parameters to the prepared statement
			pstmt.setInt(1, 2);
			pstmt.setString(2, "C");
			pstmt.setString(3, "D");
			pstmt.setString(4, "C D");
			pstmt.setInt(5, 30000);
			pstmt.setString(6, "Second Street");
			pstmt.setString(7, "08-Jul-1991");

			pstmt.execute();

			// Setting parameters to the prepared statement

			pstmt.setInt(1, 3);
			pstmt.setString(2, "E");
			pstmt.setString(3, "F");
			pstmt.setString(4, "E F");
			pstmt.setInt(5, 40000);
			pstmt.setString(6, "Third Street");
			pstmt.setString(7, "08-Jul-1992");

			pstmt.execute();

			conn.commit();
			logger.info("Method insertor -- Executed insert data into DB");

		} catch (Exception e) {
			logger.error("Method insertor -- Exception is thrown, so rolling back " + e);
			conn.rollback();

		} finally {
			conn.setAutoCommit(true);
		}

	}

	protected static void deletor(Connection conn) throws SQLException {

		// Deleting into DB using prepared statement

		// conn.prepareStatement is used to send parameterized statement to DB

		String sqldel = "DELETE FROM brbtable where id=?";
		try (PreparedStatement pstmtDel = conn.prepareStatement(sqldel)) {

			pstmtDel.setInt(1, 2);
			pstmtDel.execute();

			logger.info("Method deletor -- Deleted data from db of id=2");
		}

		catch (SQLException e) {
			logger.error("Method deletor -- SQL Exception is thrown, so rolling back" + e);
		}

		finally {
			conn.setAutoCommit(true);
		}

	}

	protected static void checkTransactionManagement(Connection conn) throws SQLException {

		logger.info(
				"Method checkTransactionManagement -- Trying to insert multiple values and a Duplicate value inside DB of id=1");

		String sqlTrans = "INSERT INTO brbtable (id,firstname,lastname,fullname,salary,street,doj) "
				+ "VALUES(?,?,?,?,?,?,?)";

		try (PreparedStatement pstmtChk = conn.prepareStatement(sqlTrans)) {

			conn.setAutoCommit(false);

			// Setting parameters to the prepared statement
			pstmtChk.setInt(1, 4);
			pstmtChk.setString(2, "G");
			pstmtChk.setString(3, "H");
			pstmtChk.setString(4, "G H");
			pstmtChk.setInt(5, 50000);
			pstmtChk.setString(6, "Fourth Street");
			pstmtChk.setString(7, "28-Jul-1994");

			pstmtChk.execute();

			// Setting parameters to the prepared statement
			pstmtChk.setInt(1, 1);
			pstmtChk.setString(2, "A");
			pstmtChk.setString(3, "B");
			pstmtChk.setString(4, "A B");
			pstmtChk.setInt(5, 20000);
			pstmtChk.setString(6, "First Street");
			pstmtChk.setString(7, "28-Jul-1990");

			pstmtChk.execute();

			conn.commit();

		}

		catch (Exception e) {

			logger.error("Method checkTransactionManagement -- Exception is thrown " + e);
			conn.rollback();

			logger.error(
					"Method checkTransactionManagement -- Rolled back. None of the unique entry is commited due to unique constraint");
		}

		finally {

			conn.setAutoCommit(true);

			logger.info("Method checkTransactionManagement -- Finally!!!!!! Clearing all the values from the table");

			String truncateTable = "truncate brbtable";

			try (PreparedStatement truncateStmt = conn.prepareStatement(truncateTable)) {
				truncateStmt.execute();

				logger.debug("Method checkTransactionManagement -- Flushed table");
			} catch (Exception e) {
				logger.error("Method checkTransactionManagement -- Table is not cleared due to " + e);
			}
		}

	}

}
