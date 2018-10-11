package com.mly.employee.filter.service.impl;

import com.mly.employee.filter.service.FilterOperatorProcessor;
import com.mly.employee.model.Employee;
import com.mly.employee.model.FilterOperator;

public class FilterOperatorProcessorFactory {

	public static FilterOperatorProcessor<Employee> getInstance(FilterOperator operator) {
		FilterOperatorProcessor<Employee> filterOperatorProcessor = null;
		if (operator == FilterOperator.EQUAL) {
			filterOperatorProcessor = new EqualToFilterOperatorProcessor();
		} else if (operator == FilterOperator.NOT_EQUAL) {
			filterOperatorProcessor = new NotEqualToFilterOperatorProcessor();
		} else if (operator == FilterOperator.LESS_THAN) {
			filterOperatorProcessor = new LessThanFilterOperatorProcessor();
		} else if (operator == FilterOperator.LESS_THAN_EQUAL) {
			filterOperatorProcessor = new LessThanEqualToFilterOperatorProcessor();
		} else if (operator == FilterOperator.GREATER_THAN) {
			filterOperatorProcessor = new GreaterThanFilterOperatorProcessor();
		} else if (operator == FilterOperator.GREATER_THAN_EQUAL) {
			filterOperatorProcessor = new GreaterThanEqualToFilterOperatorProcessor();
		}
		return filterOperatorProcessor;
	}
}
