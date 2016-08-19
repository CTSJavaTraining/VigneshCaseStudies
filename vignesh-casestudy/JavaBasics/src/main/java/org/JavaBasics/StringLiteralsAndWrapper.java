package org.JavaBasics;

import org.apache.log4j.Logger;

/**
 * This class is used to compare string literals and string object using
 * literalsValidation method
 */
public class StringLiteralsAndWrapper {

	static Logger logger = Logger.getLogger(StringLiteralsAndWrapper.class);

	String litJames = "James";
	String litNewJames = "James";

	String objMartin = new String("Martin");
	String objNewMartin = new String("Martin");

	/**
	 * Compares String literals and string object
	 */
	void literalsValidation() {

		if (litJames == litNewJames) {
			logger.info(
					"literalsValidation Method: Literals Equal. String litJames and litNewJames are literals and can be checked for equals using == operator");
		}

		if (objMartin.equals(objNewMartin)) {
			logger.info(
					"literalsValidation Method: String Object Equals can be validated only using .equals method of String class");
		}

	}

}
