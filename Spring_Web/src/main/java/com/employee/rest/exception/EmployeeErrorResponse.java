package com.employee.rest.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeErrorResponse {

	private int status;
	private String message;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy 'T' HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private Date date;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EmployeeErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeErrorResponse(int status, String message, Date date) {
		super();
		this.status = status;
		this.message = message;
		this.date = date;
	}

}
