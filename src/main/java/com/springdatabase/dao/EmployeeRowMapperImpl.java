package com.springdatabase.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springdatabase.beans.Employee;

public class EmployeeRowMapperImpl implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Referencing the employee object.
		Employee employee = new Employee();

		employee.setEmployeeId(rs.getInt(1));
		employee.setEmployeeName(rs.getString(2));
		employee.setEmployeeCity(rs.getString(3));
		return employee;
	}

}
