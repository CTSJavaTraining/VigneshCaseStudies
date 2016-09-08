package org.training.jps;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * AOP logging class for cross-cutting method and performing necessary actions
 * 
 * @author 447482
 *
 */
@Aspect
@Configuration
public class AOPLogging {
	
	private static Logger logger = Logger.getLogger(AOPLogging.class);

	/**
	 * Following is the definition for a pointcut to select all the methods
	 * available. So advice will be called for all the methods.
	 */
	@Pointcut("execution(* AOPTester.addPerson(..))")
	private void defaultInsertion() {
		logger.info("PointCut: Execution begins");
	}
	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 * @param jp Join point
	 */
	@Before("defaultInsertion()")
	public void beforeInsertor() {
		logger.info("Before Advice: Going to begin transaction");
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	@After("defaultInsertion()")
	public void afterInsertor() {
		logger.info("After Advice: Transaction is commited and session is closed");
	}

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised by any method.
	 * 
	 * @param ex
	 */ 
	@AfterThrowing(pointcut = "defaultInsertion()", throwing = "ex")
	public void afterThrowingAdvice(NullPointerException ex) {
		logger.info("After Throwing Advice: There has been an exception AFTER THROWING ADVICE AOP: " + ex.toString());
	}

}