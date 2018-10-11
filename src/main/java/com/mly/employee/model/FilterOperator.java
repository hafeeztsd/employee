package com.mly.employee.model;

public enum FilterOperator {

	LESS_THAN("lt"), LESS_THAN_EQUAL("lte"), GREATER_THAN("gt"), 
	GREATER_THAN_EQUAL("gte"), EQUAL("eq"),NOT_EQUAL("ne");
	
	private String value;

	FilterOperator(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
