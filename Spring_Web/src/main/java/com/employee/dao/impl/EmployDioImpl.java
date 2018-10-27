package com.employee.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.Employee;
import com.employee.dao.EmployDio;

@Repository
public class EmployDioImpl implements EmployDio {

	static List<Employee> employees = new ArrayList<>();

	static {
		employees.add(new Employee(1, "ravi"));
		employees.add(new Employee(2, "amit"));
		employees.add(new Employee(3, "rohit"));
	}

	@Override
	public Employee getEmployee(int id) {
		return employees.get(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return employees;
	}

}
