package org.javabasics;

/**
 * Fetches information from Database. NOTE: DataBase is not yet set.
 */
public class FetchSearchString extends EnterSearchString {

	FetchSearchString(String gUrl, String searchString) {
		super(gUrl, searchString);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to fetch searchString from DB
	 */
	public void fetch() {
		logger.debug("fetch Method: Fetch information from DB. DB is not yet set");
	}

}
