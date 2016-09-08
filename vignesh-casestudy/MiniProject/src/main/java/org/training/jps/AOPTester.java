package org.training.jps;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * AOP Loggin tester
 * 
 * @author 447482
 *
 */
@Component
public class AOPTester {

	private static Logger logger = Logger.getLogger(AOPTester.class);

	/**
	 * Sample method to test AOP logging
	 */
	public void addPerson() {

		logger.info("Test AOP logging");

	}
}
