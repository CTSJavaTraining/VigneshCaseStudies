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
	
		employeeList.add(new EmployeeDetails("A", "12-12-1992", 20000));
		employeeList.add(new EmployeeDetails("C", "12-11-1992", 40000));
		employeeList.add(new EmployeeDetails("B", "12-10-1992", 30000));
		
		
		
		
	}

}
