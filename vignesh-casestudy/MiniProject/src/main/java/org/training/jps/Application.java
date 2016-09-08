package org.training.jps;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring boot application and using of rest services, Hibernate ORM.
 * 
 * @author 447482
 *
 */
@SpringBootApplication
public class Application {

	private static final Logger logger = Logger.getLogger(Application.class);

	/**
	 * Main method for mini project application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		logger.info("----------------Application begins-------------------");

		insertorUsingSetter();

	}

	/**
	 * Method: Loads default employee and address details into DB using spring
	 * application context xml
	 */
	public static void insertorUsingSetter() {

		ApplicationContext contextXml = new ClassPathXmlApplicationContext("applicationContext.xml");

		AOPTester aopt = (AOPTester) contextXml.getBean("AopTest");
		aopt.addPerson();

		SessionFactory factory = factoryBuilder();
		try (Session session = factory.openSession()) {

			Transaction tx = session.beginTransaction();

			Employee emp1 = (Employee) contextXml.getBean("insertIntoEmployee");
			Address address1 = (Address) contextXml.getBean("insertIntoAddress1");
			Address address2 = (Address) contextXml.getBean("insertIntoAddress2");

			address1.setForeignId(emp1);

			address2.setForeignId(emp1);

			session.persist(emp1);
			session.persist(address1);
			session.persist(address2);

			tx.commit();

		} catch (Exception e) {
			logger.error("Exception in main" + e);
		} finally {
			((AbstractApplicationContext) contextXml).close();
		}

	}

	/**
	 * Utility method for reusing SessionFactory
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory factoryBuilder() {
		return new Configuration().configure().buildSessionFactory();
	}

}
