package com.tagore.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

public class JdbcTemplateExceptionApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		OrganizationDAO orgDao = (OrganizationDAO) ctx.getBean("orgDao");

		List<Organization> orgs = null;
		try {
			orgDao.getAllOrganizations();
		}catch (BadSqlGrammarException e) {
			System.out.println("Sub-Exception message: " + e.getMessage());
			System.out.println("Sub-Exception Class: " + e.getClass());

		}
		catch (DataAccessException e) {
			System.out.println("Exception message: " + e.getMessage());
			System.out.println("Exception Class: " + e.getClass());
		}

		for (Organization org : orgs) {
			System.out.println(org);
		}

		((ClassPathXmlApplicationContext) ctx).close();
	}

}
