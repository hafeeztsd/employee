package com.mly.employee.model;

public class FilterCriteria {

	private FilterOperator operator;
	private SortOperator sort;
	private int age;

	public FilterOperator getOperator() {
		return operator;
	}

	public void setOperator(FilterOperator operator) {
		this.operator = operator;
	}

	public SortOperator getSort() {
		return sort;
	}

	public void setSort(SortOperator sort) {
		this.sort = sort;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
