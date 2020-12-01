package com.springdatabase.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springdatabase.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public int createEmployee(Employee employee) {

		// Insert Employee to the database

		String insertQuery = "insert into employee(employeeId, employeeName, employeeCity) values (?,?,?)";
		int insert = this.jdbcTemplate.update(insertQuery, employee.getEmployeeId(), employee.getEmployeeName(),
				employee.getEmployeeCity());
		return insert;
	}

	public int updateEmployee(Employee employee) {

		// Update existing employee in the database

		String updateQuery = "update employee set employeeName=?, employeeCity=? where employeeId=?";
		int update = jdbcTemplate.update(updateQuery, employee.getEmployeeName(), employee.getEmployeeCity(),
				employee.getEmployeeId());
		return update;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
