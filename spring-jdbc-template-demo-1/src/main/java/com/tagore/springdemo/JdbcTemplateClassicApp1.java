package com.tagore.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

public class JdbcTemplateClassicApp1 {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		OrganizationDAO orgDao = (OrganizationDAO) ctx.getBean("orgDao");

		List<Organization> orgs = orgDao.getAllOrganizations();

		for (Organization org : orgs) {
			System.out.println(org);
		}

		((ClassPathXmlApplicationContext) ctx).close();
	}

}
