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
 * Main class for check set and get method of employee and address
 * 
 * @author 447482
 *
 */

@SpringBootApplication
public class Application {

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

		System.out.println(
				"*****************************************************************************************************************************************************");
		ApplicationContext contextXml = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory factory = factoryBuilder();
		try (Session session = factory.openSession()) {

			AOPTester aopT = new AOPTester();
			aopT.addPerson();

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

	public static SessionFactory factoryBuilder() {
		return new Configuration().configure().buildSessionFactory();
	}

}
