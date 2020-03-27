package com.playground.testjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playground.testjpa.model.Employee;
import com.playground.testjpa.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

private EmployeeRepository repository;

public EmployeeService(EmployeeRepository repository) {
	this.repository = repository;
}

public List<Employee> findAllEmployees() {
	List<Employee> employees = new ArrayList<Employee>();
	repository.findAll().iterator().forEachRemaining(employees::add);
	
	return employees;
}

public List<Employee> saveEmployee(List<Employee> employee) {
	employee.stream().forEach(e -> Employee.builder()
			.employeeId(e.getEmployeeId())
			.employeeAge(e.getEmployeeAge())
			.employeeName(e.getEmployeeName())
			.build());
	
	List<Employee> employees = new ArrayList<Employee>();
	repository.saveAll(employee).iterator().forEachRemaining(employees::add);
	
	return employees;
}

public void deleteEmployee(Employee employee) {
	repository.deleteByemployeeId(employee.getEmployeeId());
}

public List<Employee> findEmployeeDetailsByName(Employee employee) {
	List<Employee> detailsEmployees = repository.findEmployeeByEmployeeName(employee.getEmployeeName());
	System.out.println(detailsEmployees);
	return detailsEmployees;
}

}
