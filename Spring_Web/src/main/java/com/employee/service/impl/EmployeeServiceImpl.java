package com.employee.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Optional<Employee> getEmployee(Long id) {
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> getEmployees() {

		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {

		return employeeDao.save(employee);

	}

	@Override
	public void deleteEmployee(Long id) {
		employeeDao.deleteById(id);
	}

	@Override
	public Optional<Employee> findByName(String name) {
		return employeeDao.findByName(name);
	}

	@Override
	public Optional<Employee> findByIdAndName(Long id, String name) {
		return employeeDao.findByIdAndName(id, name);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public Iterable<Employee> saveEmployees(Set<Employee> employees) {

		Iterable<Employee> employee = null;
		employee = employeeDao.saveAll(employees);
		// getException();

		return employee;
	}

	@Transactional(propagation = Propagation.NEVER, isolation = Isolation.READ_UNCOMMITTED, rollbackFor = RuntimeException.class)
	private void getException() {

		throw new RuntimeException();

	}

}
