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
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setAge(12);
		employee.setFullName("Abdul Hafeez");
		employee.setSalary(1452);
		int id = employeeService.createEmployee(employee);
		Assert.assertTrue("Invalid ID returned by employee create service", id > 0);
	}

	@Test
	public void testFindAllEmployees() {
		Employee employee = new Employee();
		employee.setAge(17);
		employee.setFullName("Abdul Sattar");
		employee.setSalary(1400);
		employeeService.createEmployee(employee);
		List<Employee> employees = employeeService.findAllEmployees();
		Assert.assertTrue("No Employee found ", employees.size() > 0);
	}

	@Test
	public void testUpdateEmployee() {
		String correctName = "Test User";
		Employee employee = new Employee();
		employee.setAge(20);
		employee.setFullName("Tst Usr");
		employee.setSalary(5000);
		employeeService.createEmployee(employee);
		employee.setFullName(correctName);
		employee = employeeService.updateEmployee(employee);
		Assert.assertTrue("No Employee found ", employee.getFullName().equals(correctName));
	}


	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee();
		employee.setAge(20);
		employee.setFullName("User to be deleted");
		employee.setSalary(5000);
		int id = employeeService.createEmployee(employee);
		boolean deleted = employeeService.deleteEmployeeById(id);
		Assert.assertFalse("Employee still exist ", !deleted);
	}
	
}
