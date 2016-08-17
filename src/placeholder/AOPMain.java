package placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ShapeService;

public class AOPMain {
	public static void main(String[] args) {
		//Here will instantiate Spring application context
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//							context.getBean("NAMEOFBEAN", ) gives an object, 2nd Argument Casts the Bean to .class specified
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		
		//Example of methods being called getCircle getTriangle getName that will trigger the LoggingAspect Advice methods
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());
		shapeService.getCircle().setName("Jeff's Circle");
		shapeService.getTriangle().annotationMethod();

		//Be Good Close a Resource
		((ConfigurableApplicationContext)context).close();
	}
	

}
