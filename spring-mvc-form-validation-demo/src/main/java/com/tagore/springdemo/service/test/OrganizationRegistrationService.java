package com.tagore.springdemo.service.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrganizationRegistrationService {

	@Value("#{serviceLengthOptions}")
	private Map<String, String> serviceLengthList;
	
	public Map<String, String> populateTurnOver(){
		Map<String, String> turnOver =  new LinkedHashMap<>();
		turnOver.put("None", "-----SELECT-----");
		turnOver.put("1000", "Less than $1000");
		turnOver.put("10000", "Greater than $1000 and Less than $10000");
		turnOver.put("100000", "Greater than $10000 and Less than $100000");
		return turnOver;
	}
	
	public Map<String, String> populateTypes(){
		Map<String, String> types =  new LinkedHashMap<>();
		types.put("gov", "Government");
		types.put("semi-gov", "Semi-Government");
		types.put("private", "Private");
		return types;
	}
	
	public Map<String, String> populateServiceLength(){
		return new TreeMap<String, String>(serviceLengthList);
	}
	
	public Map<String, String> populateRegisteredPreviously(){
		Map<String, String> registeredPreviously =  new LinkedHashMap<>();
		registeredPreviously.put("true", "Yes");
		registeredPreviously.put("false", "No");
		return registeredPreviously;
	}
	
	public Map<String, String> populateOptionalServices(){
		Map<String, String> optionalServices =  new LinkedHashMap<>();
		optionalServices.put("emailService", "Mailing List");
		optionalServices.put("promotionalService", "Promotional Emails");
		optionalServices.put("newsLetterService", "Weekly Newsletter");
		return optionalServices;
	}
	
	public Map<String, String> populatePremiumServices(){
		Map<String, String> premiumServices =  new LinkedHashMap<>();
		premiumServices.put("directoryService", "Directory");
		premiumServices.put("revenueReportService", "Revenue Reports");
		premiumServices.put("revenureAnalyticservice", "Revenue Analytics");
		return premiumServices;
	}
	
	public Map<String, String> populateEmployeeStrength(){
		Map<String, String> employeeStrength =  new LinkedHashMap<>();
		employeeStrength.put("small", "less than 100");
		employeeStrength.put("medium", "greater than 100 and less than 1000");
		employeeStrength.put("large", "greater than 1000");
		return employeeStrength;
	}
}
