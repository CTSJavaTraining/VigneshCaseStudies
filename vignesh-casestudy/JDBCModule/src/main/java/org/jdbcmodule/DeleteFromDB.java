package org.jdbcmodule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * 
 * @author VICKY BRB
 *Delete data from DB
 */
public class DeleteFromDB {

	private static final Logger logger = Logger.getLogger(DeleteFromDB.class);

	private DeleteFromDB() {
	}

	protected static void deletor(Connection conn) throws SQLException {

		// Deleting into DB using prepared statement

		// conn.prepareStatement is used to send parameterized statement to DB
		PreparedStatement pstmtDel = null;

		try {
			conn.setAutoCommit(false);

			String sqldel = "DELETE FROM brbtable where id=?";
			pstmtDel = conn.prepareStatement(sqldel);
			pstmtDel.setInt(0, 447383);
			pstmtDel.execute();

			logger.info("Deleted data from db");
			pstmtDel.close();
		}

		catch (SQLException e) {
			logger.error("SQL Exception is thrown, so rolling back" + e);
			conn.rollback();
		}

		finally {
			conn.setAutoCommit(true);
		}

	}
}
