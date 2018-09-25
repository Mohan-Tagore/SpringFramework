package com.tagore.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tagore.springdemo.domain.Organization;
import com.tagore.springdemo.domain.promotion.TradeFair;

public class PropertiesWithXmlApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		Organization organization = (Organization) ctx.getBean("myorg");
		System.out.println(organization);
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
