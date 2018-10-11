package com.mly.employee.filter.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.mly.employee.filter.service.FilterOperatorProcessor;
import com.mly.employee.model.Employee;

public class NotEqualToFilterOperatorProcessor implements FilterOperatorProcessor<Employee> {

	@Override
	public List<Employee> filter(List<Employee> list, int value) {
		return list.stream().filter(e -> e.getAge() != value).collect(Collectors.toList());
	}

}
