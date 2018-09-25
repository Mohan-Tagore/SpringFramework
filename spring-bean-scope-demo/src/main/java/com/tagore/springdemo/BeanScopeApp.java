package com.tagore.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tagore.springdemo.domain.Organization;

public class BeanScopeApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		
		Organization org = (Organization) ctx.getBean("myorg");
		
		Organization org2 = (Organization) ctx.getBean("myorg");
		org2.setPostalCode("90009");
	
	//	System.out.println(org.corporateSlogan());
		//System.out.println(org.corporateService());
		
		System.out.println(org);
		System.out.println(org2);
		
		if(org == org2) {
			System.out.println("Singleton class");
		}
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
