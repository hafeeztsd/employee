package com.mly.employee.service;

import java.util.List;

import com.mly.employee.model.Employee;
import com.mly.employee.model.FilterCriteria;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> findAllEmployees();
	
	List<Employee> findEmployeesByCriteria(FilterCriteria filterCriteria);

	Employee updateEmployee(Employee employee);

	boolean deleteEmployeeById(int id);

	Employee findEmployeeById(int id) ;
}
