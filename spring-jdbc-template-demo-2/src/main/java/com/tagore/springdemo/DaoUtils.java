package com.tagore.springdemo;

import java.util.ArrayList;
import java.util.List;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

public class DaoUtils {

	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanupOperation = "TRUNCATE";

	public static void printOrganizations(List<Organization> orgs, String operation) {
		System.out.println("\n******Printing Organizations after " + operation + " operation *************");
		for (Organization org : orgs) {
			System.out.println(org);
		}
	}

	public static void printSuccessFailure(String operation, boolean param) {
		if (param) {
			System.out.println("\n******** Operation " + operation + " successful *************");
		} else {
			System.out.println("\n******** Operation " + operation + " failure *************");
		}

	}

	public static void createSeedData(OrganizationDAO orgDao) {
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

		System.out.println("Created " + createCount + " Organizations");
	}

	public static void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.println("\n******** Currently we have " + orgs.size() + " organizations after " + operation
				+ " operation **************");
	}
	
	public static void printOrganization(Organization org, String operation) {
		System.out.println("\n******** Printing Organization " + org + " organizations after " + operation
				+ " operation **************");
	}

}
