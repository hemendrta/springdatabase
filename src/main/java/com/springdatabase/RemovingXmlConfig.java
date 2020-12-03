package com.springdatabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springdatabase.dao.EmployeeDaoImpl;

@Configuration
public class RemovingXmlConfig {

	@Bean("driverManagerDataSource")
	public DriverManagerDataSource getDriverManagerDataSource() {

		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/springdatabase";
		String username = "root";
		String password = "root";

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDriverManagerDataSource());
		return jdbcTemplate;
	}
	
	@Bean("employeeDaoImpl")
	public EmployeeDaoImpl getEmployeeDaoImpl() {
		
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		employeeDaoImpl.setJdbcTemplate(getJdbcTemplate());
		return employeeDaoImpl;
	}

}
