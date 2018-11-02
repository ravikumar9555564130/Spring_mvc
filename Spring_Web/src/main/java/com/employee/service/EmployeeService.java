package com.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.employee.entity.Employee;

public interface EmployeeService {

	Optional<Employee> getEmployee(Long id);

	List<Employee> getEmployees();

	Employee createEmployee(Employee employee);

	void deleteEmployee(Long id);

	Optional<Employee> findByName(String name);

	Optional<Employee> findByIdAndName(Long id, String name);

	Iterable<Employee> saveEmployees(Set<Employee> employees);

}
