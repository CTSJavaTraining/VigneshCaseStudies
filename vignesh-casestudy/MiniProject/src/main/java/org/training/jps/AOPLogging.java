package org.training.jps;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AOPLogging {

   /** Following is the definition for a pointcut to select
    *  all the methods available. So advice will be called
    *  for all the methods.
    */
   @Pointcut("execution(* org.training.jps.AOPTester.addPerson(..))")
   private void defaultInsertion(){
	   System.out.println("PointCut: Execution begins");
   }

   /** 
    * This is the method which I would like to execute
    * before a selected method execution.
    */
   @Before("defaultInsertion()")
   public void beforeInsertor(){
      System.out.println("Before Advice: Going to begin transaction");
   }

   /** 
    * This is the method which I would like to execute
    * after a selected method execution.
    */
   @After("defaultInsertion()")
   public void afterInsertor(){
      System.out.println("After Advice: Transaction is commited and session is closed");
   }

/*   *//** 
    * This is the method which I would like to execute
    * when any method returns.
    *//*
   @AfterReturning(pointcut = "defaultInsertion()", returning="retVal")
   public void afterReturningAdvice(Object retVal){
      System.out.println("Returning:" + retVal.toString() );
   }*/

   /**
    * This is the method which I would like to execute
    * if there is an exception raised by any method.
    */
   @AfterThrowing(pointcut = "defaultInsertion()", throwing = "ex")
   public void AfterThrowingAdvice(IllegalArgumentException ex){
      System.out.println("There has been an exception AFTER THROWING ADVICE AOP: " + ex.toString());   
   }
   
}