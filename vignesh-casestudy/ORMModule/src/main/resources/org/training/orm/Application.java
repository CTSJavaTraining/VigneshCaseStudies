package org.training.orm;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ORM Application includes Spring boot to start the application.
 * 
 * @author 447482
 *
 */
public class Application {

	private static final Logger logger = Logger.getLogger(Application.class);

	private Application() {
	}

	/**
	 * main methodo of ORM Application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info("----------------------Main Method: ORM Application begins-------------------------");

		ApplicationContext ormxml = new ClassPathXmlApplicationContext("bootxml");
		try(){
			
		}
		catch(){
			
		}
		finally{
		((AbstractApplicationContext) ormxml).close();
		}
	}

}
