package com.tagore.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		
		Organization org = (Organization) ctx.getBean("myorg");
	
		org.corporateSlogan();
		
		System.out.println(org);
		
		Organization org2 = (Organization) ctx.getBean("myorg2");
		
		org2.corporateSlogan();
		
		System.out.println(org2);
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
