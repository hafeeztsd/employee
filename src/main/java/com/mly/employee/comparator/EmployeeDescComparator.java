package com.mly.employee.comparator;

import java.util.Comparator;

import com.mly.employee.model.Employee;

public class EmployeeDescComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getAge().compareTo(o1.getAge());
	}

}
