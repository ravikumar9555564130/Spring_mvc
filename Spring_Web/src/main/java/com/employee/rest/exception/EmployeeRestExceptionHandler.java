package com.employee.rest.exception;

import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> hanleException(EmployeeNotFoundException enployeeNotFoundException) {

		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
		employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		employeeErrorResponse.setMessage(enployeeNotFoundException.getMessage());
		employeeErrorResponse.setDate(Calendar.getInstance().getTime());

		ResponseEntity<EmployeeErrorResponse> responseEntity = new ResponseEntity<EmployeeErrorResponse>(
				employeeErrorResponse, HttpStatus.NOT_FOUND);

		return responseEntity;

	}

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> hanleGenericException(Exception exception) {

		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
		employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		employeeErrorResponse.setMessage(exception.getMessage());
		employeeErrorResponse.setDate(Calendar.getInstance().getTime());

		ResponseEntity<EmployeeErrorResponse> responseEntity = new ResponseEntity<EmployeeErrorResponse>(
				employeeErrorResponse, HttpStatus.BAD_REQUEST);

		return responseEntity;

	}

}
