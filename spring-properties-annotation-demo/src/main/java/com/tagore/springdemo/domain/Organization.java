package com.tagore.springdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.tagore.springdemo.service.BusinessService;

@Component("myorg")
public class Organization {

	@Value("${nameOfCompany}")
	private String companyName;

	@Value("${startUpYear}")
	private int yearOfIncorporation;

	@Value("${postalCode}")
	private String postalCode;

	@Value("${empCount: 22222}")
	private int employeeCount;

	@Value("${corporateSlogan: We build world class software!}")
	private String slogan;

	private String missionStatement;

	@Autowired
	private Environment env;

	private BusinessService businessService;

	public Organization() {
	}

	public Organization(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("Organization: Inside Constructor");
	}

	public String corporateSlogan() {
		missionStatement = env.getProperty("statement");
		return missionStatement + " And also " + slogan;
	}

	/*
	 * public void initialize() { System.out.println("Organization: Initialized"); }
	 * 
	 * public void destroy() { System.out.println("Organization: Destroyed"); }
	 */

	public void postInitialize() {
		System.out.println("Organization: Initialized");
	}

	public void preDestroy() {
		System.out.println("Organization: Destroyed");
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("Postal Code is set");
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("Employee Count is set");
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("Slogan is set");
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("Business Service is set");
	}

	public String corporateService() {
		return businessService.offerService(companyName);
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}

}
