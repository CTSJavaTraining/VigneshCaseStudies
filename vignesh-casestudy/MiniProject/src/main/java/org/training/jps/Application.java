package org.training.jps;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for check set and get method of employee and address
 * 
 * @author 447482
 *
 */

@SpringBootApplication
public class Application {

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static final Logger logger = Logger.getLogger(Application.class);

	/**
	 * CRUD Operation is performed from here
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		logger.info("----------------Application begins-------------------");
		
		insertorUsingSetter();

	}

	public static void insertorUsingSetter() {
		
		try (Session session = factory.openSession()) {

			Transaction tx = session.beginTransaction();

			Employee emp1 = new Employee();

			logger.info("----------------Connecting to DB and inserting values----------------");

			emp1.setName("Vignessh");
			emp1.setDesignation("PA");
			emp1.setSalary(20000);
			emp1.setBonus(2000);
			emp1.setDoj("July 31");
			emp1.setGrade("A");
			emp1.setemailid("mytbrb@gmail.com");

			Address address1 = new Address();

			logger.info("Adding address values");

			address1.setDoorno(9);
			address1.setState("TN");
			address1.setStreetname("Test Street");
			address1.setForeignId(emp1);

			Address address2 = new Address();

			address2.setDoorno(12);
			address2.setState("KL");
			address2.setStreetname("Test2 Street");
			address2.setForeignId(emp1);

			Address address3 = new Address();

			address3.setDoorno(13);
			address3.setState("KL");
			address3.setStreetname("Test2 Street");
			address3.setForeignId(emp1);

			List<Address> addresslist = new ArrayList<>();
			addresslist.add(address1);
			addresslist.add(address2);
			addresslist.add(address3);

			logger.debug("Address set");
			emp1.setAddress(addresslist);

			logger.debug("address set inside employee");

			session.persist(emp1);
			logger.debug("session saved");
			tx.commit();
			logger.debug("Commited");
		} catch (Exception e) {
			logger.error("Exception in main" + e);
		}

	}
}
