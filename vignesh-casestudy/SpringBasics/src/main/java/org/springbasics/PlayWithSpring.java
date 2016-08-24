package org.springbasics;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Core Application. Setter injection, Constructor injector, creating xml
 * for bean to take control
 *
 * @author 447482
 *
 */
public class PlayWithSpring {

	private static final Logger logger = Logger.getLogger(PlayWithSpring.class);

	private PlayWithSpring() {

	}

	public static void main(String[] args) {

		ApplicationContext basicXml = new ClassPathXmlApplicationContext("basicXml.xml");
		try {

			Player groundname = (Player) basicXml.getBean("setterbean");

			logger.info("Setter injection is used " + groundname.getGround());

			logger.info("Constructor injection is used " + groundname.getWater());

		}

		finally {
			((AbstractApplicationContext) basicXml).close();
		}

	}
}
