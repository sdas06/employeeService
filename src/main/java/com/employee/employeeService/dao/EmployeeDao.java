package com.employee.employeeService.dao;

import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.model.EmployeePayload;

public interface EmployeeDao {
	
	public String createNewEmployee(Employee employeeEntity);

	public String updateEmployeeById(Employee empEntity, Long id);

}
