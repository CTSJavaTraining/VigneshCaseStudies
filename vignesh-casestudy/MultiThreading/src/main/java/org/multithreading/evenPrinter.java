package org.multithreading;

import java.util.List;
import org.apache.log4j.Logger;

public class evenPrinter implements Runnable {

	static Logger logger = Logger.getLogger(evenPrinter.class);

	private int num;
	
	private static final ThreadLocal<String> transID = new ThreadLocal<String>();

	private List<Integer> numberStorage;

	evenPrinter(List<Integer> numberStorage) {
		this.numberStorage = numberStorage;
	}

	public void run() {

		transID.set(Double.toString(Math.random()));

		logger.info("Thread evenPrinter");
		// TODO Auto-generated method stub

		logger.debug("Buyer running");

		while (num <= 10) {

			num = numberStorage.get(numberStorage.size() - 1);

			synchronized (numberStorage) {

				if (num % 2 == 0 && num <= 10) {

					logger.debug("Transaction ID is " + transID.get() + " " + Thread.currentThread().getName()
							+ " Number is Even " + num);

					try {

						numberStorage.wait();

					} catch (InterruptedException e) {
						logger.error("",e);
						
					}

					num++;

					numberStorage.add(num);

				}

				else if (num <= 10) {

					numberStorage.notify();
				}

			}
		}
		transID.remove();
	}
}
