package com.employee.employeeService.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeeService.dao.EmployeeDao;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.model.EmployeePayload;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public String createNewEmployee(EmployeePayload employeePayload) {
		// TODO Auto-generated method stub
		slf4jLogger.info("EmployeeServiceImpl-Create New Employee starting:::");
		Employee empEntity = mapModelToDTO(employeePayload);
		slf4jLogger.info("EmployeeServiceImpl-Create New Employee ending:::");
		return employeeDao.createNewEmployee(empEntity);
	}
	
	@Override
	public String updateEmployeeById(EmployeePayload employeePayload, Long id) {
		// TODO Auto-generated method stub
		slf4jLogger.info("EmployeeServiceImpl-update Employee starting:::");
		Employee empEntity = mapModelToDTO(employeePayload);
		slf4jLogger.info("EmployeeServiceImpl-update Employee ending:::");
		return employeeDao.updateEmployeeById(empEntity, id);
	}
	
	public Employee mapModelToDTO(EmployeePayload employeePayload) {
		slf4jLogger.info("EmployeeServiceImpl-map model calling:::");
		Employee empEntity = new  Employee();
		empEntity.setEmpId(employeePayload.getId());
		empEntity.setEmpName(employeePayload.getName());
		empEntity.setDepartmentName(employeePayload.getDeptName());
		empEntity.setJoiningDate(new Date());
		slf4jLogger.info("EmployeeServiceImpl-map model finished:::");
		return empEntity;
		
		
	}

	

}
