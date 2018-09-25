package com.tagore.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationDAO organizationDAO;
	
	public List<Organization> getOrgList(){
		List<Organization> orgList = organizationDAO.getAllOrganizations();
		return orgList;
	}
}
