package com.tagore.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

@Repository("orgDao")
public class OrganizationDAOImpl implements OrganizationDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean createOrganization(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public Organization getOrganization(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Organization> getAllOrganizations() {
		String sQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public void cleanUp() {
		// TODO Auto-generated method stub

	}

}
