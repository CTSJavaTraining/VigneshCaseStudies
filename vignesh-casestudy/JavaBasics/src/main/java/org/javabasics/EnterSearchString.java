package org.javabasics;

/**
 * This is an abstract class extended from GoogleUrl class
 */
abstract class EnterSearchString extends GoogleUrl {

	protected String searchString;

	EnterSearchString(String gUrl, String searchString) {
		super(gUrl);
		this.searchString = searchString;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to enter search String to be fetched
	 */
	@Override
	public void search() {
		logger.debug("search Method: " + gUrl + " now searches are " + searchString);
	}
}