package com.employee.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

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
	public Iterable<Employee> saveEmployees(Set<Employee> employees) {
		return employeeDao.saveAll(employees);
	}

}
