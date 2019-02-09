package com.employee.employeeService.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.employeeService.dao.EmployeeDao;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.model.EmployeePayload;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public String createNewEmployee(EmployeePayload employeePayload) {
		// TODO Auto-generated method stub
		Employee empEntity = mapModelToDTO(employeePayload);
		return employeeDao.createNewEmployee(empEntity);
	}
	
	@Override
	public String updateEmployeeById(EmployeePayload employeePayload, Long id) {
		// TODO Auto-generated method stub
		Employee empEntity = mapModelToDTO(employeePayload);
		return employeeDao.updateEmployeeById(empEntity, id);
	}
	
	private Employee mapModelToDTO(EmployeePayload employeePayload) {
		
		Employee empEntity = new  Employee();
		empEntity.setEmpId(employeePayload.getId());
		empEntity.setEmpName(employeePayload.getName());
		empEntity.setDepartmentName(employeePayload.getDeptName());
		empEntity.setJoiningDate(new Date());
		return empEntity;
		
		
	}

	

}
