package org.training.jps;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Main class for check set and get method of employee and address
 * 
 * @author 447482
 *
 */
public class Application {

	private static final Logger logger = Logger.getLogger(Application.class);

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	/**
	 * CRUD Operation is performed from here
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("----------------Application begins-------------------");
		
		

		try (Session session = factory.openSession()) {

			Transaction tx = session.beginTransaction();
			
			Address address1 = new Address();
			//address1.setForeignId(447482);
			address1.setDoorno(9);
			address1.setState("TN");
			address1.setStreetname("Test Street");
			address1.setAddressid(123);

			Address address2 = new Address();
			//address2.setForeignId(447482);
			address2.setDoorno(12);
			address2.setState("KL");
			address2.setStreetname("Test2 Street");
			address2.setAddressid(456);

			List<Address> addresslist = new ArrayList<>();
			addresslist.add(address1);
			//addresslist.add(address2);
			
			Employee emp1 = new Employee();

			//emp1.setId(447482);
			emp1.setName("Vignessh");
			emp1.setDesignation("PA");
			emp1.setSalary(20000);
			emp1.setBonus(2000);
			emp1.setDoj("July 31");
			emp1.setGrade("A");
			emp1.setemailid("vigneshbabu.brb@gmail.com");

			

			emp1.setAddress(addresslist);

			session.save(emp1);

			tx.commit();
			logger.info("Saved");
		}
	}

}
