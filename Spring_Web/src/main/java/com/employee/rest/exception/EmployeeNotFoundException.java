package com.employee.rest.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1213408794670251372L;

	public EmployeeNotFoundException(String message) {
		super(message);

	}

}
