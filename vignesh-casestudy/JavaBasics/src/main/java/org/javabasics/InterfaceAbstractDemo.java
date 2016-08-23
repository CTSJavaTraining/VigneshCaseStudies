package org.javabasics;

/**
 * Created Interface with open, search and fetch methods which is implemented in
 * an abstract class GoogleUrl.java for open method is extended to
 * EnterSearchString.java uses open method and search method is extended to
 * FetchSearchString.java uses fetch metod and super of open and search.
 */
public interface InterfaceAbstractDemo {

	/**
	 * Opens URL
	 */
	void uOpen();

	/**
	 * Searches for a string using url
	 */
	void sSearch();

	/**
	 * Fetches data from DB (Just a check for interface and abstract Demo)
	 */
	void dFetch();

}
