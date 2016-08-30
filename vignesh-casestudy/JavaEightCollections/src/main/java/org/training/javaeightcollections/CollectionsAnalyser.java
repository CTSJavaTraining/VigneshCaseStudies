package org.training.javaeightcollections;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Uses Java 7 and Java 8 collection and Collections to find the difference
 * between them
 * 
 * @author 447482
 *
 */
public class CollectionsAnalyser {
	
	

	private static final Logger logger = Logger.getLogger(CollectionsAnalyser.class);

	private CollectionsAnalyser() {

	}

	/**
	 * Method:
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info("------------------------------------Application starts------------------------------");
		dataStore();
	}

	/**
	 * Stores employees details in a collection
	 */
	public static void dataStore() {

		List<Object> employeeList = new LinkedList<>();
		employeeList.add("1");

		
		
		
		
	}

}
