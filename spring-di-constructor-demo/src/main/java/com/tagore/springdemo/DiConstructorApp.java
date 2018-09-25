package com.tagore.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tagore.springdemo.domain.HumanResourceDept;
import com.tagore.springdemo.domain.Organization;

public class DiConstructorApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		
		Organization org = (Organization) ctx.getBean("myorg");
	
		System.out.println(org.corporateSlogan());
//		System.out.println(org.corporateService());
//		System.out.println(org);
		
		HumanResourceDept hrdept = (HumanResourceDept) ctx.getBean("myhrdept");
		System.out.println(hrdept.hiringStatus(5000));
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
