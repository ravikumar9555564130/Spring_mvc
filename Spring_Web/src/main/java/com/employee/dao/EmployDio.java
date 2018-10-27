package com.employee.dao;

import java.util.List;

import com.employee.Employee;

public interface EmployDio {

	Employee getEmployee(int id);

	List<Employee> getEmployees();

}
