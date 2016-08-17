package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AroundAspect {

	//Around Advice
	//Used in case of a target method that needs an advice method to run both before and after the target method
	//The advice method must take the argument (ProceedingJoinPoint pjp) and @Around annotation takes the normal pointcut statement
	
	@Pointcut("execution(* get*(..))")
	public void beforeAllGetters() {}
	
	@Around("beforeAllGetters()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) {
		//Before Target Method Code
		Object returnValue = null; //Because the method called returns a string
									//need a return Value to pass back to
									//original targeted method
	
		//This is Where the Target method code is run
		//Can use conditionals above and if conditionals aren't met then can skip the execution of 
		//of the target method (waay cool) 
		try {
			System.out.println("***An Around Advice Before Getter Executes***");
			returnValue = pjp.proceed(); //since it is a get method a string is returned
			System.out.println("***An Around Advice after Getter Executes***");
		} catch(Throwable ex) {
			System.out.println(ex);
		} finally {
			
		}
		
		//After Target method code is executed
		System.out.println("***An Around Advice after Finally***");
			return returnValue; //Here return the string to the original targeted method,
			//if this aroundAdvice method had a "void" return type
			//then the call to the getter in target method would throw a null pointer exception
		
	}
}
