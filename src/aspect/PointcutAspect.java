package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutAspect {

	//PointCut is a place in the code where want a method to "cut in"
	//If have multiple advice methods that need to run at the same point in the code
	//use so that do not have to repeat complicated execution statements
	@Pointcut("execution(public String getName(..))")
	public void allGetName() {	}
	
	//Here you can see the pointcut is being used with the placeholder method allGetName()
	@Before("allGetName()")
	public void secondLoggingAdvice() {
		System.out.println("This is advice is given at defined PointCut targeting all getName() methods");
	}
	
}
