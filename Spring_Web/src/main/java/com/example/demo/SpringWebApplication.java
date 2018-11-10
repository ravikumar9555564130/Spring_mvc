package com.example.demo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.impl.EmployeeServiceImpl;
import com.properties.Propertieshandler;

@SpringBootApplication
@ComponentScan(basePackages = { "com.employee", "com.properties" })
@EntityScan(basePackages = { "com.employee" })
@EnableJpaRepositories("com.employee")
@EnableTransactionManagement
@PropertySource("classpath:test.properties")
public class SpringWebApplication {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringWebApplication.class, args);

		//reading properties file
		Propertieshandler Propertieshandler = context.getBean(Propertieshandler.class);
		Propertieshandler.readingPropertiesFile();

		EmployeeService employeeService = context.getBean(EmployeeServiceImpl.class);

		saveEmployees(employeeService);

		// getEmployee(employeeService);
	}

	private static void saveEmployees(EmployeeService employeeService) {

		Department department = new Department();
		department.setName("CS");
		department.setBlock("A");

		Set<Employee> employees = new HashSet<>();

		Employee employee1 = new Employee();
		employee1.setName("ravi");
		employee1.setAddress("sasaram");
		employee1.setDepartment(department);

		employees.add(employee1);

		Employee employee2 = new Employee();
		employee2.setName("amit");
		employee2.setAddress("pune");
		employee2.setDepartment(department);

		employees.add(employee2);

		Employee employee3 = new Employee();
		employee3.setName("rohit");
		employee3.setAddress("delhi");
		employee3.setDepartment(department);

		employees.add(employee3);

		// department.setEmployees(employees);

		employeeService.saveEmployees(employees);
	}

	private static void getEmployee(EmployeeService employeeService) {
		Optional<Employee> employee = employeeService.getEmployee(1l);

		if (employee.isPresent()) {
			System.out.println("employee::id " + employee.get().getId());
			System.out.println("employee::name " + employee.get().getName());
			System.out.println("employee::adress " + employee.get().getAddress());
		}

		employee = employeeService.findByName("amit");

		if (employee.isPresent()) {
			System.out.println("employee::id " + employee.get().getId());
			System.out.println("employee::name " + employee.get().getName());
			System.out.println("employee::adress " + employee.get().getAddress());
		}

		employee = employeeService.findByIdAndName(3l, "vikash");

		if (employee.isPresent()) {
			System.out.println("employee::id " + employee.get().getId());
			System.out.println("employee::name " + employee.get().getName());
			System.out.println("employee::adress " + employee.get().getAddress());
		}
	}
}
