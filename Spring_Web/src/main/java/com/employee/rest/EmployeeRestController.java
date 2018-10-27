package com.employee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee;
import com.employee.service.EmployService;

@RestController
public class EmployeeRestController {

	@Autowired
	EmployService employService;
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return employService.getEmoloyee(id);
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return employService.getEmployees();
	}

}
