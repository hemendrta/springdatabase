package com.springdatabase.dao;

import com.springdatabase.beans.Employee;

public interface EmployeeDao {

	public int createEmployee(Employee employee);

	public int updateEmployee(Employee employee);
	
	public int deleteEmployee(int employeeId);
	
	public Employee getEmployee(int employeeId);

}
