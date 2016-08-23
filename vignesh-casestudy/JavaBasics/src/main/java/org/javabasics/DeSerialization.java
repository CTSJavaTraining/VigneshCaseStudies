package org.javabasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.log4j.Logger;

public class DeSerialization {

	private static Logger logger = Logger.getLogger(DeSerialization.class);

	/**
	 * STATIC METHOD Here we are sending file to be read and deserialize.
	 * 
	 * @param fileName
	 *            -- Filename of the file to be read and deserialize.
	 * @throws IOException--IOException
	 *             will be thrown while Reading a network file and got
	 *             disconnected. Reading a local file that was no longer
	 *             available. Using some stream to read data and some other
	 *             process closed the stream. Trying to read/write a file but
	 *             don't have permission. Trying to write to a file but disk
	 *             space was no longer available.
	 * @throws ClassNotFoundException
	 *             --Thrown when an application tries to load in a class through
	 *             its string name using: The forName method in class Class. The
	 *             findSystemClass method in class ClassLoader . The loadClass
	 *             method in class ClassLoader.
	 * 
	 */

	public static void deserialize(String fileName) throws IOException {

		logger.debug("deserialize method: Input fileName is " + fileName);

		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee objde = null;

		try {
			objde = (Employee) ois.readObject();
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}

		ois.close();
		fis.close();

		logger.debug("deserialize method: Deserialized and output is " + objde);
		logger.info("deserialize method: Closed FileInputStream and ObjectInputStream");

	}
}
