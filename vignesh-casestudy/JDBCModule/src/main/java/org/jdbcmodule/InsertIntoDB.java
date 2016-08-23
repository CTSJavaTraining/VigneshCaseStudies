package org.jdbcmodule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Class to insert data into DB
 * 
 * @author VICKY BRB
 *
 */
public class InsertIntoDB {

	private static final Logger logger = Logger.getLogger(InsertIntoDB.class);

	private InsertIntoDB() {
	}

	protected static void insertor(Connection conn) throws SQLException {
		// Inserting into DB using prepared statement

		// conn.prepareStatement is used to send parameterized statement to DB

		String sql = "INSERT INTO brbtable (id,firstname,lastname,fullname,salary,street,doj) "
				+ "VALUES(?,?,?,?,?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			conn.setAutoCommit(false);

			// Setting parameters to the prepared statement
			pstmt.setInt(1, 1);
			pstmt.setString(2, "A");
			pstmt.setString(3, "P");
			pstmt.setString(4, "K P");
			pstmt.setInt(5, 20000);
			pstmt.setString(6, "Anasd nagar");
			pstmt.setString(7, "28-Jul-1990");

			pstmt.execute();

			// Setting parameters to the prepared statement
			pstmt.setInt(1, 2);
			pstmt.setString(2, "B");
			pstmt.setString(3, "Psad");
			pstmt.setString(4, "K Pasd");
			pstmt.setInt(5, 20002);
			pstmt.setString(6, "Aassdasdnna nagar");
			pstmt.setString(7, "08-Jul-1991");

			pstmt.execute();

			// Setting parameters to the prepared statement
			pstmt.setInt(1, 3);
			pstmt.setString(2, "C");
			pstmt.setString(3, "Psaqwed");
			pstmt.setString(4, "K Pasqweqwed");
			pstmt.setInt(5, 200123323);
			pstmt.setString(6, "Aassd");
			pstmt.setString(7, "08-Jul-1891");

			// Inserting into DB and closing the preparedstatement

			pstmt.execute();

			logger.info("Executed insert data into DB");

			conn.commit();

		} catch (Exception e) {
			logger.error("Exception is thrown, so rolling back");
			logger.error(e);
			conn.rollback();

		} finally {
			conn.setAutoCommit(true);
		}
	}
}
