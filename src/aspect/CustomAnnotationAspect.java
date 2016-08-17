package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CustomAnnotationAspect {

	//Custom Annotations that can target methods natively in their classes
	//First create a custom annotation here created @CustomAspectAnnotation can have extra code, but just need the empty @interface for annotation
	//@annotation takes the annotation class itself with the full package name and @interface Annotation
	@Pointcut("@annotation(aspect.CustomAspectAnnotation)")
	public void customAnnotationAdvice() {}
	
	@Before("customAnnotationAdvice()")
	public void annotationAdvice() {
		System.out.println("Advice coming as a result of the Custom annotation");
	}
}
