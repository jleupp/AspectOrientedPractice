package aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeforeAndWildCardAspect {
	//Aspect starts off as a class with the @Aspect annotation becomes a true Aspect
	//Any methods in Aspect become advice
	
	//Cross cutting concern ("Advice") method
	//@Before annotation tells the aspect to run this advice method before the method passed as an argument in the execution parameter
	@Before("execution(public String getName())")
	public void LoggingAdvice() {
		System.out.println("Running Advice...  The \"getName\" method has been called");
	}
	//This advice only runs for Circle class and runs after the method is executed
	@After("execution(public String model.Circle.getName())")
	public void CircleOnlyExecutionAdvice() {
		System.out.println("You were looking for a Circle, correct?");
	}
	
	//This Advice will be applied to all getters in the program
	//Wildcards are used here for both the return type and after "get" so that all getters are included
	//If methods may or may not take arguments can modify the execution parameter
	//(exectution(public * get*())		--This will only run when method has zero arguments 
	//(exectution(public * get*(*))		--This will only run when method has one or more arguments 
	//(exectution(public * get*(..))		--This will always Run with zero to n arguments 
	@Before("execution(public * get*())")
	public void getterAdviceLogging() {
		System.out.println("Advice has been executed before a get method");
	}
	
	//Here is an example of targeting all methods whose argument is a single string
	//In this case the setName(String name) methods are targeted and whatever name is sent to be set
	//is printed out to the console
	@Before("args(foo)")
	public void printOutTheStringAdvice(String foo) {
		System.out.println("Shapes Name: " + foo + "\t\t Targeted methods whose argument is a single String");
	}
	
	//By using proper package structure, can set a Pointcut to target every
	//method in every class located in specified package
	//service.*.* specifies of all wildcard classes in service package and all methods in those classes
	//and (..) says all methods with zero -> n parameters
	@Pointcut("execution(* service.*.*(..))")
	public void allMethodsAllClassesInServicePackage() {}

}
