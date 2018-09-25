package com.tagore.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tagore.springdemo.domain.Organization;

public class PNameSpaceApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		
		Organization org = (Organization) ctx.getBean("myorg");
	
		System.out.println(org);
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
