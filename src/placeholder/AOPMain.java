package placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {
	public static void main(String[] args) {
		//Here will instantiate Spring application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
	}

}
