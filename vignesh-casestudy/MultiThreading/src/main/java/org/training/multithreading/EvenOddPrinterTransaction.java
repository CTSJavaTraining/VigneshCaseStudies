package org.training.multithreading;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * MAIN method loads log4j congifiguration files and starts thread for two
 * classes {@link EvenOddPrinterTransaction} and {@link oddPrinter}
 * 
 * Starting two threads Thread1 and Thread2.
 */
public class EvenOddPrinterTransaction {

	private EvenOddPrinterTransaction() {
	}

	/**
	 * Runs tasks as even and odd printers
	 * 
	 * @param args
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) {

		final Logger logger = Logger.getLogger(EvenOddPrinterTransaction.class);

		logger.info("---------------------Application Starts---------------------");

		List<Integer> numberStorage = new LinkedList<>();
		numberStorage.add(0);

		EvenPrinter ePrinter = new EvenPrinter(numberStorage);
		Thread firstThread = new Thread(ePrinter);

		OddPrinter oPrinter = new OddPrinter(numberStorage);
		Thread secondThread = new Thread(oPrinter);

		firstThread.setName("Thread1");
		secondThread.setName("Thread2");

		firstThread.start();
		secondThread.start();
	}
}
