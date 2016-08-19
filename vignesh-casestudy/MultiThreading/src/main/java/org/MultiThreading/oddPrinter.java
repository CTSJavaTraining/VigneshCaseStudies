package org.MultiThreading;

import java.util.List;

import org.apache.log4j.Logger;

public class oddPrinter implements Runnable {

	static Logger logger = Logger.getLogger(oddPrinter.class);

	private int num;
	
	private List<Integer> numberStorage;
	
	private static final ThreadLocal<String> transID = new ThreadLocal<String>();

	oddPrinter(List<Integer> numberStorage) {
		this.numberStorage = numberStorage;
	}

	public void run() {

		transID.set(Double.toString(Math.random()));

		logger.info("Thread oddPrinter");
		// TODO Auto-generated method stub

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
						// TODO Auto-generated catch block
						e.printStackTrace();
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