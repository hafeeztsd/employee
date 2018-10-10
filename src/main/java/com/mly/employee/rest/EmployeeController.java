package com.mly.employee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mly.employee.model.Employee;
import com.mly.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable int id) {
		Employee employee = employeeService.findEmployeeById(id);
		if (null == employee) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/employees/{id}")
	public Boolean deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployeeById(id);
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployees(Employee employee) {
		return employeeService.createEmployee(employee);
	}

}
