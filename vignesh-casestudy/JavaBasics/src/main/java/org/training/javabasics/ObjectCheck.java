package org.training.javabasics;

import org.apache.log4j.Logger;
//Slf4j

/**
 * This class is created for TRAINING DEMO-1
 * 
 * @To create object using new keyword
 * @To inherit a class
 * @To clone an object
 * @To use static variable
 */

public class ObjectCheck implements Cloneable {

	static Logger logger = Logger.getLogger(ObjectCheck.class);
	// Created static variable. This will help store the state of 'staticVar'
	// after incrementing it.
	static int staticVar = 0;

	/**
	 * Increments the static value of staticVar from 0 and stores the value with
	 * every time the method is called.
	 */
	void incrementer() {

		logger.info("incrementer Method: staticVar is " + staticVar);

		staticVar = staticVar + 1;

	}

	/**
	 * Cloneable is an interface of ObjectClass so it is necessary to define.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

/**
 * ObjectCheckChild class is inherited form ObjectCheck class only to cross
 * verify the increment of 'staticVar'
 */
class ObjectCheckChild extends ObjectCheck {

	/**
	 * incrementcheck() checks the value of 'staticVar' whether incremented from
	 * its previous value.
	 */
	void incrementcheck() {
		logger.info("incrementCheck Method:Extended Method incrementcheck of Child class ObjectCheckChild");
		logger.info("incrementCheck Method:staticVar is " + staticVar);
	}
}
