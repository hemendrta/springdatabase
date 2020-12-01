package com.springdatabase.beans;

/*Declaration of the bean class which we want to persist to the database.*/

public class Employee {

	private int employeeId;
	private String employeeName;
	private String employeeCity;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeName, String employeeCity) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeCity = employeeCity;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeCity="
				+ employeeCity + "]";
	}

}
