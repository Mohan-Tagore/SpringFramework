package com.tagore.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

@Component
public class NamedJdbcTemplateClassicApp1 {

	@Autowired
	private OrganizationDAO dao;

	@Autowired
	private DaoUtils daoUtils;

	public void actionMethod() {

		daoUtils.createSeedData(dao);

		List<Organization> orgs = dao.getAllOrganizations();
		daoUtils.printOrganizations(orgs, daoUtils.readOperation);

		Organization org = new Organization("General Electric", 1978, "97879", 5776, "Imagination at work");

		boolean isCreated = dao.createOrganization(org);

		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);

		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, daoUtils.readOperation);

		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build awesome awesome driving machines");
		boolean isUpdated = dao.update(org3);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);

		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);

		dao.cleanUp();
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanupOperation);
	}

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		NamedJdbcTemplateClassicApp1 mainApp = ctx.getBean(NamedJdbcTemplateClassicApp1.class);
		mainApp.actionMethod();
		
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
