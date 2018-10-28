package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.entity.Employee;

public interface EmployeeService {
	
	Optional<Employee> getEmployee(Long id);

	List<Employee> getEmployees();

	Employee createEmployee(Employee employee);

	void deleteEmployee(Long id);

}
