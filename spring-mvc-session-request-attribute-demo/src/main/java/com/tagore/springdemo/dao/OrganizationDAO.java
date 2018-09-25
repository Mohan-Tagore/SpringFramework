package com.tagore.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.tagore.springdemo.domain.Organization;

public interface OrganizationDAO {

	public void setDataSource(DataSource ds);

	public boolean createOrganization(Organization org);

	public Organization getOrganization(Integer id);

	public List<Organization> getAllOrganizations();

	public boolean delete(Organization org);

	public boolean update(Organization org);

	public void cleanUp();
}
