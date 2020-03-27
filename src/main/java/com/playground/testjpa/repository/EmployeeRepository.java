package com.playground.testjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.playground.testjpa.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	void deleteByemployeeId(Integer employeeId);
	
    @Query(value = "SELECT e.employee_Name, e.employee_Age, e.employee_Id FROM employee e WHERE e.employee_Name = :employeeName", nativeQuery = true)
	List<Employee> findEmployeeByEmployeeName(@Param("employeeName") String employeeName); 

}
