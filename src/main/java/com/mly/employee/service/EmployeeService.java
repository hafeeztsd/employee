package com.mly.employee.service;

import java.util.List;

import com.mly.employee.model.Employee;

public interface EmployeeService {

	int createEmployee(Employee employee);

	List<Employee> findAll();

	
}
