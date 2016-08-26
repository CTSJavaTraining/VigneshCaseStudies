package org.training.javaeightcollections;

/**
 * Employee Class to store employee details
 * 
 * @author 447482
 *
 */
public class EmployeeDetails {

	private static String employeeName;
	private static String employeeDOJ;
	private static int employeeSal;

	/**
	 * Constructor to set employee name, doj and salary
	 * 
	 * @param employeeName
	 * @param employeeDOJ
	 * @param employeeSal
	 */
	protected EmployeeDetails(String employeeName, String employeeDOJ, int employeeSal) {
		EmployeeDetails.employeeName = employeeName;
		EmployeeDetails.employeeDOJ = employeeDOJ;
		EmployeeDetails.employeeSal = employeeSal;
	}

	public static String getEmployeeName() {
		return employeeName;
	}

	public static String getEmployeeDOJ() {
		return employeeDOJ;
	}

	public static int getEmployeeSal() {
		return employeeSal;
	}

}
