package com.tagore.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

public class JdbcTemplateClassicApp2 {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		OrganizationDAO orgDao = (OrganizationDAO) ctx.getBean("orgDao");
		
		DaoUtils.createSeedData(orgDao);
		
		List<Organization> orgs = orgDao.getAllOrganizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);

		Organization org = new Organization("General Electric", 1978, "97879", 5776, "Imagination at work");
		
		boolean isCreated = orgDao.createOrganization(org);
		
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizations(orgDao.getAllOrganizations(), DaoUtils.readOperation);
		
		Organization org2 = orgDao.getOrganization(1);
		DaoUtils.printOrganization(org2, DaoUtils.readOperation);
		
		Organization org3 = orgDao.getOrganization(2);
		org3.setSlogan("We build awesome awesome driving machines");
		boolean isUpdated = orgDao.update(org3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(orgDao.getOrganization(2), DaoUtils.updateOperation);
		
		boolean isDeleted = orgDao.delete(orgDao.getOrganization(3));
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(orgDao.getAllOrganizations(), DaoUtils.readOperation);
		
		orgDao.cleanUp();
		DaoUtils.printOrganizationCount(orgDao.getAllOrganizations(), DaoUtils.cleanupOperation);
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
