package com.employee.employeeService.service;

import com.employee.employeeService.model.EmployeePayload;

public interface EmployeeService {
	
	public String createNewEmployee(EmployeePayload employeePayload);

	public String updateEmployeeById(EmployeePayload employeePayload, Long id);

}
