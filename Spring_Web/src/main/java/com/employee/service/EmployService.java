package com.employee.service;

import java.util.List;

import com.employee.Employee;

public interface EmployService {
	
	Employee getEmoloyee(int id);

	List<Employee> getEmployees();

}
