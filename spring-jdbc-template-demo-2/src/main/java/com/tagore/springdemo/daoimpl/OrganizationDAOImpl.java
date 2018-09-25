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
		String sQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) "
				+ "VALUES(?, ?, ?, ?, ?)";
		Object[] args = new Object[] { org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(),
				org.getEmployeeCount(), org.getSlogan() };

		return jdbcTemplate.update(sQuery, args) == 1;
	}

	public Organization getOrganization(Integer id) {
		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan"
				+ " FROM organization WHERE id=?";
		Object[] args = new Object[] { id };
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {
		String sQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		String sqlQuery = "DELETE FROM organization WHERE id = ?";
		Object[] args = new Object[] {org.getId()};
		return jdbcTemplate.update(sqlQuery, args)==1;
	}

	public boolean update(Organization org) {
		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] args = new Object[] {org.getSlogan(), org.getId()};
		return jdbcTemplate.update(sqlQuery, args)==1;
	}

	public void cleanUp() {
		String sqlQuery = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sqlQuery);
	}

}
