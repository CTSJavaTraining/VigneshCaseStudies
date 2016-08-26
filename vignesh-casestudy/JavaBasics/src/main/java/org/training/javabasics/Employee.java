package org.training.javabasics;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * Employee Plain Java class for performing setter and getter and Serialization
 * of object.
 *
 */
public class Employee implements Serializable {

	static Logger logger = Logger.getLogger(Employee.class);

	private static final long serialVersionUID = 1L;

	private static String name;
	private int id;
	private transient int salary;

	@Override
	/**
	 * Overriding toString
	 */
	public String toString() {
		return "Employee{name=" + name + " id=" + id + ", salary=" + salary + "}";
	}

	// Writing getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		Employee.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
