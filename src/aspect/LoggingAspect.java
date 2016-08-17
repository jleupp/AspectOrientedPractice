package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import model.Triangle;

@Aspect
public class LoggingAspect {
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
	
	//PointCut is a place in the code where want a method to "cut in"
	//If have multiple advice methods that need to run at the same point in the code
	//use so that do not have to repeat complicated execution statements
	@Pointcut("execution(public String getName(..))")
	public void allGetName() {	}
	
	//Here you can see the pointcut is being used with the placeholder method allGetName()
	@Before("allGetName()")
	public void secondLoggingAdvice() {
		System.out.println("This is secondary advice, given at defined PointCut for getName() methods");
	}	
	
	@Pointcut("within(model.Triangle)")
	public void allTriangleMethods() {}
	
	@Before("allTriangleMethods()")
	public void triangleAdvice() {
		System.out.println("This is advice before triangle methods pointcut");
	}
	
	//JoinPoint Example
	//All possible places where you can apply advice it is information passed by Spring as an argument to Advice method
	
	@Before("allTriangleMethods()")
	public void enhancedTriangleAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.toString());  //Prints out what method was called in this case model.Triangle.getName()
		Object obj = joinPoint.getTarget();		//THIS IS HUGE Spring passes the Object whose method was called!! 
												//Called in this case on a Triangle object have that object to work with in Aspect
		System.out.println("Advice on the Class of the Object sent from Spring " + obj.getClass());
		System.out.println("Advice on Objects name: " + ((Triangle)obj).getName());
	}
	
	@Before("args(foo)")
	public void printOutTheStringAdvice(String foo) {
		System.out.println("Name: " + foo);
	}

}
