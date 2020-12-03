package com.springdatabase.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springdatabase.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	/* Inserting a record in database. */

	public int createEmployee(Employee employee) {

		// Insert Employee to the database

		String insertQuery = "insert into employee(employeeId, employeeName, employeeCity) values (?,?,?)";
		int insert = this.jdbcTemplate.update(insertQuery, employee.getEmployeeId(), employee.getEmployeeName(),
				employee.getEmployeeCity());
		return insert;
	}

	/* updating a record in database. */

	public int updateEmployee(Employee employee) {

		// Update existing employee in the database

		String updateQuery = "update employee set employeeName=?, employeeCity=? where employeeId=?";
		int update = jdbcTemplate.update(updateQuery, employee.getEmployeeName(), employee.getEmployeeCity(),
				employee.getEmployeeId());
		return update;
	}

	/* Deleting a record from database. */

	public int deleteEmployee(int employeeId) {
		// Delete an existing record from database.

		String deleteQuery = "delete from employee where employeeId=?";

		int delete = jdbcTemplate.update(deleteQuery, employeeId);

		return delete;
	}

	/* Selecting single record from the database. */

	public Employee getEmployee(int employeeId) {
		// selecting a record from database.

		String selectQuery = "select * from employee where employeeId=?";
		RowMapper<Employee> rowMapper = new EmployeeRowMapperImpl();
		Employee employee = jdbcTemplate.queryForObject(selectQuery, rowMapper, employeeId);
		return employee;
	}

	/* Selecting all employees from the database. */

	public List<Employee> getEmployees() {
		// Selecting all employees from database.

		String selectQueryAll = "select * from employee";
		List<Employee> employees = jdbcTemplate.query(selectQueryAll, new EmployeeRowMapperImpl());
		return employees;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
