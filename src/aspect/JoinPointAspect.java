package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import model.Triangle;

@Aspect
public class JoinPointAspect {
	//Establish a pointcut for all methods within Triangle.class
	@Pointcut("within(model.Triangle)")
	public void allTriangleMethods() {}
	
	@Before("allTriangleMethods()")
	public void triangleAdvice() {
		System.out.println("This is advice before triangle methods pointcut[][][][]");
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
}
