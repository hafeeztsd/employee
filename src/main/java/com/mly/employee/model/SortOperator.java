package com.mly.employee.model;

public enum SortOperator {

	ASCENDING("asc"), DESCENDING("desc");

	private String value;

	SortOperator(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
