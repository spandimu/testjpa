package com.playground.testjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.playground.testjpa.model.Employee;
import com.playground.testjpa.service.EmployeeService;

@RestController
public class JPADemoController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(path = "/greetings")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping(path="/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.findAllEmployees();
	}
	
	@PostMapping(path="/save")
	public List<Employee> saveEmployeeDetails(@RequestBody List<Employee> employee){
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping(path="/deleteEmployeebyId")
	public void deleteEmployeeDetails(@RequestBody Employee employee){
		employeeService.deleteEmployee(employee);
	}
	
	@PostMapping(path="/employeedetailsbyname")
	public List<Employee> getEmployeeDetails(@RequestBody Employee employee){
		return employeeService.findEmployeeDetailsByName(employee);
	}
}
