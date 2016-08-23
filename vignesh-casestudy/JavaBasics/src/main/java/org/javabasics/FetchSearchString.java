package org.javabasics;

/**
 * Fetches information from Database. NOTE: DataBase is not yet set.
 */
public class FetchSearchString extends EnterSearchString {

	FetchSearchString(String gUrl, String searchString) {
		super(gUrl, searchString);
	}

	@Override
	public void dFetch() {
		logger.debug("fetch Method: Fetch information from DB. DB is not yet set");
	}

}
