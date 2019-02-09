package com.employee.employeeService.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employeeService.entity.Employee;


public interface EmpRepository extends JpaRepository<Employee, Long> {
	
	Collection<Employee> findByEmpName(String empName);
	Employee findByEmpId(long empId);

}
