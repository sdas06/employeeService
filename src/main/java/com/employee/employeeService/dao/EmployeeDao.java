package com.employee.employeeService.dao;

import com.employee.employeeService.entity.Employee;

public interface EmployeeDao {
	
	public String createNewEmployee(Employee employeeEntity);

	public String updateEmployeeById(Employee empEntity, Long id);

}
