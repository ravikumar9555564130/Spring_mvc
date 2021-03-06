package com.employee.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.rest.exception.EmployeeNotFoundException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeRestController {

	@Autowired
	EmployeeService employService;

	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") Long id) {
		Optional<Employee> employee = employService.getEmployee(id);
		System.out.println("empluyee  :: " + employee);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("No Record found for Employee id :- " + id);
		}
		return employee;
	}

	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return employService.getEmployees();
	}

	@PostMapping(path = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee createEmployee(@RequestBody Employee employee) {

		return employService.createEmployee(employee);
	}

	@DeleteMapping(path = "/employee/{id}")
	void deleteEmployee(@PathVariable("id") Long id) {
		employService.deleteEmployee(id);
	}

}
