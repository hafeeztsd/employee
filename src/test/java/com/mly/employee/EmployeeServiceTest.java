package com.mly.employee;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mly.employee.model.Employee;
import com.mly.employee.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EmployeeServiceTestConfig.class })
public class EmployeeServiceTest {


	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testFindAllWithNoEmployee() {
		List<Employee> employees = employeeService.findAll();
		Assert.assertTrue("Some Employees found.", employees.isEmpty());
	}

	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		int id = employeeService.createEmployee(employee);
		Assert.assertTrue("Invalid ID returned by employee create service", id > 0);
	}


}
