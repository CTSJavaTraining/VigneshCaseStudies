package org.javabasics;

import org.apache.log4j.Logger;

/**
 * This class implements InterfaceAbstractDemo interface which as open, search
 * and fetch abstract methods.
 */
abstract class GoogleUrl implements InterfaceAbstractDemo {

	static Logger logger = Logger.getLogger(InterfaceAbstractDemo.class);

	protected String gUrl;

	GoogleUrl(String gUrl) {
		this.gUrl = gUrl;
	}

	@Override
	public void uOpen() {
		logger.debug("open Method: URL given and website opens " + gUrl);
	}

}
