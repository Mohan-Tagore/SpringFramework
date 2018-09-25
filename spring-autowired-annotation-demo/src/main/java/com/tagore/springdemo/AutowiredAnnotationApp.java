package com.tagore.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tagore.springdemo.domain.promotion.TradeFair;

public class AutowiredAnnotationApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		TradeFair tradeFair = (TradeFair) ctx.getBean("myFair");
		System.out.println(tradeFair.specialPromotionalPricing());
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
