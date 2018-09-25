package com.tagore.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCVersionControlApp1 {

	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");

		
		Organization org = (Organization) ctx.getBean("myorg");
	
		org.corporateSlogan();
		
		((FileSystemXmlApplicationContext) ctx).close();
	}

}
