package com.tagore.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.tagore.springdemo.dao.OrganizationDAO;
import com.tagore.springdemo.domain.Organization;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public boolean createOrganization(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		
		String sQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) "
				+ "VALUES(:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";
		/*Object[] args = new Object[] { org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(),
				org.getEmployeeCount(), org.getSlogan() };
*/
		return namedParameterJdbcTemplate.update(sQuery, beanParams) == 1;
	}

	public Organization getOrganization(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan"
				+ " FROM organization WHERE id=:ID";
//		Object[] args = new Object[] { id };
		Organization org = namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {
		String sQuery = "SELECT * FROM organization";
		List<Organization> orgList = namedParameterJdbcTemplate.query(sQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "DELETE FROM organization WHERE id = :id";
		//Object[] args = new Object[] {org.getId()};
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	public boolean update(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		//Object[] args = new Object[] {org.getSlogan(), org.getId()};
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	public void cleanUp() {
		String sqlQuery = "TRUNCATE TABLE organization";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}
