package com.mly.employee.comparator;

import java.util.Comparator;

import com.mly.employee.model.Employee;

public class EmployeeAscComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge().compareTo(o2.getAge());
	}

}
