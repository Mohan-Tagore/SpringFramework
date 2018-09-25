package com.tagore.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

@Service
public class DaoUtils {

	private static Logger LOGGER = LoggerFactory.getLogger("Logging Tester");
	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";

	public void printOrganizations(List<Organization> orgs, String operation) {
		LOGGER.info("\n******Printing Organizations after " + operation + " operation *************");
		for (Organization org : orgs) {
			LOGGER.info(org.toString());
		}
	}

	public void printSuccessFailure(String operation, boolean param) {
		if (param) {
			LOGGER.info("\n******** Operation " + operation + " successful *************");
		} else {
			LOGGER.info("\n******** Operation " + operation + " failure *************");
		}

	}

	public void createSeedData(OrganizationDAO orgDao) {
		Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
		Organization org2 = new Organization("BMW", 1929, "45454", 5071, "We build ultimate driving machines");
		Organization org3 = new Organization("Google", 1996, "57575", 4576, "Dont be evil");

		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(org1);
		orgs.add(org2);
		orgs.add(org3);

		int createCount = 0;
		for (Organization org : orgs) {
			boolean isCreated = orgDao.createOrganization(org);
			if (isCreated)
				createCount += 1;
		}

		LOGGER.info("Created " + createCount + " Organizations");
	}

	public void printOrganizationCount(List<Organization> orgs, String operation) {
		LOGGER.info("\n******** Currently we have " + orgs.size() + " organizations after " + operation
				+ " operation **************");
	}

	public void printOrganization(Organization org, String operation) {
		LOGGER.info("\n******** Printing Organization " + org + " organizations after " + operation
				+ " operation **************");
	}

}
