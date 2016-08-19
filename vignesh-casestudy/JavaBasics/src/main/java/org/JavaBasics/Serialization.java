package org.JavaBasics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

public class Serialization {
	
	private static Logger logger = Logger.getLogger(Serialization.class);
	/**
	 * STATIC METHOD: Send object emp and filename as parameter.
	 * 
	 * @param obj
	 *            --emp as Parameter which holds name, id and salary
	 * @param fileName
	 *            --filename is the name of the file that will be created in the
	 *            current workspace.
	 * @throws IOException
	 *             --IOException will be thrown while Reading a network file and
	 *             got disconnected. Reading a local file that was no longer
	 *             available. Using some stream to read data and some other
	 *             process closed the stream. Trying to read/write a file but
	 *             don't have permission. Trying to write to a file but disk
	 *             space was no longer available.
	 */

	public static void serialize(Object obj, String fileName) throws IOException {

		logger.debug("serialize method: Input Object " + obj + "Input file name is " + fileName);
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);

		logger.info("serialize method: Serialized and Closed fileoutputstream and objectoutputstream");

		fos.close();
		oos.close();
	}

}
