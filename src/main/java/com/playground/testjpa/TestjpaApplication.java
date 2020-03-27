package com.playground.testjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.playground.testjpa.model.Employee;
import com.playground.testjpa.repository.EmployeeRepository;

@SpringBootApplication
@EnableJpaRepositories
public class TestjpaApplication{

	public static void main(String[] args) {
		SpringApplication.run(TestjpaApplication.class, args);
	}

}
