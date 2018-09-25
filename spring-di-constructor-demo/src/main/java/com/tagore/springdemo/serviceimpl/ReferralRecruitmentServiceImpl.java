package com.tagore.springdemo.serviceimpl;

import java.util.Random;

import com.tagore.springdemo.service.RecruitmentService;

public class ReferralRecruitmentServiceImpl implements RecruitmentService {

	public String recruitEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName
				+ " hired " + random.nextInt(numberOfRecruitments) + " employees"
				+ " using employee referrals";
		
		return hiringFacts;
	}

}
