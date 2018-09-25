package spring.demo.challenge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCChallenge {

	public static void main(String[] args) {
	
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("bean-challenge.xml");
		
		City city = (City)ctx.getBean("mycity");

		
		((FileSystemXmlApplicationContext)ctx).close();
		
		
		System.out.println("ClassPath \n");
		
		ApplicationContext ctx1 = new ClassPathXmlApplicationContext("bean-challenge.xml");
		
		city = (City) ctx1.getBean("mycity");
		
		((ClassPathXmlApplicationContext)ctx1).close();
	}
	

}
