package com.mly.employee.filter.service;

import java.util.List;

public interface FilterOperatorProcessor<T> {

	List<T> filter(List<T> list, int value);
}
