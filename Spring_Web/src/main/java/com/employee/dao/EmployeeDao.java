package com.employee.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {
	Optional<Employee> findByName(String name);

	Optional<Employee> findByIdAndName(Long id, String name);
}
