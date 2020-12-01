package com.springdatabase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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

		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

		/* Creating the query for inserting values in database. */
		
		String insertQuery = "insert into employee(employeeId, employeeName, employeeCity) values (?,?,?)";

		/* Firing the query using jdbcTemplate object. */
		
		int update = jdbcTemplate.update(insertQuery, 1002, "Subhash Singh Chouhan", "Indore");

		System.out.println(update + " Rows effected!!!");

		System.out.println();
	}
}
