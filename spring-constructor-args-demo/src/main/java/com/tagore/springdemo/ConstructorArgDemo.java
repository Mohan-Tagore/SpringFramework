package com.tagore.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorArgDemo {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		
		Organization org = (Organization) ctx.getBean("myorg");
	
		org.corporateSlogan();
		
		System.out.println(org);
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
