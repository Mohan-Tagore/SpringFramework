package com.tagore.springdemo.domain;

import com.tagore.springdemo.service.BusinessService;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService; 
	
	public Organization(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("Organization: Inside Constructor");
	}

	/*public void initialize() {
		System.out.println("Organization: Initialized");
	}
	
	public void destroy() {
		System.out.println("Organization: Destroyed");
	}*/
	
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


	public String corporateSlogan() {
		return slogan;
	}
	
	public String corporateService() {
		return businessService.offerService(companyName);
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}
	
	
}
