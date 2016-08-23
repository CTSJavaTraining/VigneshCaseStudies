package org.multithreading;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Odd printer prints only odd numbers as task
 * 
 * @author 447482
 *
 */
public class OddPrinter implements Runnable {

	static Logger logger = Logger.getLogger(OddPrinter.class);

	private int num;

	private List<Integer> numberStorage;

	private static final ThreadLocal<String> transID = new ThreadLocal<String>();

	OddPrinter(List<Integer> numberStorage) {
		this.numberStorage = numberStorage;
	}

	@Override
	public void run() {

		transID.set(Double.toString(Math.random()));

		logger.info("Thread oddPrinter");

		logger.debug("Seller running");

		while (num <= 10) {

			num = numberStorage.get(numberStorage.size() - 1);

			synchronized (numberStorage) {

				if (num % 2 != 0 && num <= 10) {

					logger.debug("Transaction ID is " + transID.get() + " " + Thread.currentThread().getName()
							+ " Number is Odd " + num);

					try {

						numberStorage.wait();

					} catch (InterruptedException e) {
						// Rethrowing interrupt exception (Coding standard)
						Thread.currentThread().interrupt();
						logger.error(e);
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