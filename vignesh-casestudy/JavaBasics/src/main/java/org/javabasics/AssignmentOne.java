package org.javabasics;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TRAINING DEMO-1 Main Class
 * 
 * We are using @Static method in this class which will be performed when the
 * class is loaded. And perform all other tasks mentioned in Assignment 1
 * 
 * @Program1 Interface and Abstract class with constructor chaining.
 * 
 *           InterfaceAbstractDemo.java GoogleUrl.java EnterSearchString.java
 *           FetchSearchString.java
 * 
 * @Program2 static block, static method and static variable
 * 
 *           AssignmentOne.java used static block ObjectCheck.java uses
 *           'staticVar' as static variable. Employee.java has static methods
 *           serialize and deserialize
 *
 * @Program3 Creating Objects using new keyword, cloning, reflection and
 *           serialization, deserialization
 *
 *           Created new ObjectCheck.java object using new keyword, cloning and
 *           reflection. Employee.java has two method serialize and deserialize
 *           to perform serialization and deserialization.
 * 
 * @Program4 String literals and Wrapper class explanation
 *           StringLiteralsAndWrapper.java
 */
public class AssignmentOne {

	private static Logger logger = Logger.getLogger(AssignmentOne.class);

	static {
		System.out.println("Static Block Called");
		System.out.println("NOTE:Logger is not working in static block. It throws warning");
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException,
			IllegalArgumentException, NoSuchMethodException, SecurityException, InvocationTargetException {

		// TODO Auto-generated method stub

		// Logger configuration and pointing log4j.properties ( which is to be
		// placed under src folder or WEB_INF/classes in webapplication
		
		logger.info("---------------------------------------------------######-----------------------------------");
		logger.info("main Method: Application starts");

		try {

			// 1: Creating Object using new keyword

			ObjectCheck sm1 = new ObjectCheck();

			// 2: Cloning object

			ObjectCheck sm2 = (ObjectCheck) sm1.clone();

			sm1.incrementer();
			sm2.incrementer();

			// Inheritance
			ObjectCheckChild ext = new ObjectCheckChild();
			ext.incrementcheck();

			// 3: Object Reflection
			Method method = sm1.getClass().getDeclaredMethod("incrementer");
			method.invoke(sm1);

			// 4: Serialization and Deserialization
			Employee employeeObj = new Employee();

			employeeObj.setId(447482);
			employeeObj.setName(" Babu B R B");
			employeeObj.setSalary(20000);
			String filename = "serdser.txt";

			Serialization.serialize(employeeObj, filename);
			employeeObj.setName("Kumar");
			DeSerialization.deserialize(filename);

			// 5:Constructor Chaining
			InterfaceAbstractDemo interfaceDemoObject = new FetchSearchString("www.google.com", "Cognizant MEPZ");

			interfaceDemoObject.open();
			interfaceDemoObject.search();
			interfaceDemoObject.fetch();

			// String literals and wrapper class
			StringLiteralsAndWrapper validateObj = new StringLiteralsAndWrapper();
			validateObj.literalsValidation();

		}

		catch (CloneNotSupportedException c) {
			logger.error("Clone is not supported" + c);
		}
		logger.info("main Method: Application completed processing");
		logger.info("---------------------------------------------------######-----------------------------------");
	}
}