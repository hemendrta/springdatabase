package com.springdatabase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springdatabase.beans.Employee;
import com.springdatabase.dao.EmployeeDaoImpl;

/*
We have declared a bean by the name of Employee which needs to be persisted to the database, to use the insert and other queries we require the object of JdbcTemplate which requires an object of DataSource. We have created the objects by using bean container and thus the life-cycle will be managed by the bean containers. Since DataSource is an interface thus the object of same could not be created and thus it's implementation class object is created and injected which is DriverManagerDataSource which has properties for establishing the connection.
*/
public class App {
	public static void main(String[] args) {
		System.out.println("Application Started!!!!");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

		/*
		 * Getting the object of JdbcTemplate from bean container/application context.
		 */

//		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

		/* Creating the query for inserting values in database. */

//		String insertQuery = "insert into employee(employeeId, employeeName, employeeCity) values (?,?,?)";

		/* Firing the query using jdbcTemplate object. */

//		int update = jdbcTemplate.update(insertQuery, 1004, "Aditi Singh Chouhan", "Indore");
//
//		System.out.println(update + " Rows effected!!!");

//		System.out.println();

		/* Proper implementation of the above code: */

		/*
		 * We have created Dao layer which has an interface EmployeeDao along with class
		 * EmployeeDaoImpl which is the implementation for the methods that we have in
		 * Dao. We have configured the xml so that we now get the object of
		 * EmployeeDaoImpl in which the object of JdbcTemplate is injected and there the
		 * logic for inserting the bean object is written in database.
		 */

		EmployeeDaoImpl employeeDaoImpl = applicationContext.getBean("employeeDaoImpl", EmployeeDaoImpl.class);

		/* Inserting a Record to the database: */

		/*
		 * Employee employee = new Employee(); employee.setEmployeeId(1005);
		 * employee.setEmployeeName("Sunny Singh Chouhan");
		 * employee.setEmployeeCity("Indore"); int createEmployee =
		 * employeeDaoImpl.createEmployee(employee); System.out.println(createEmployee +
		 * " rows inserted to the database!!");
		 */

		/* Updating Record in the database: */

		Employee employee = new Employee();

		employee.setEmployeeId(1004);
		employee.setEmployeeName("Aditi Gupta Chouhan");
		employee.setEmployeeCity("Indore");
		int updateEmployee = employeeDaoImpl.updateEmployee(employee);
		System.out.println(updateEmployee + " rows have been updated!!!");
	}
}
