package com.tagore.springdemo.serviceimpl;

import java.util.Random;

import com.tagore.springdemo.service.BusinessService;

public class CloudServiceImpl implements BusinessService{

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Orgainization, " + companyName
				  + " offers world class cloud computing infrastructure."+
				"\nThe annual income exceeds " + random.nextInt(revenue) + " dollars.";
		return service;
	}
	
}
