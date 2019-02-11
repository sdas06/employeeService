package com.employee.employeeService.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeeService.dao.EmployeeDao;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.model.EmployeePayload;

/**
 * @author sidharth
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.employee.employeeService.service.EmployeeService#createNewEmployee(
	 * com.employee.employeeService.model.EmployeePayload)
	 */
	@Override
	public String createNewEmployee(EmployeePayload employeePayload) {
		slf4jLogger.info("EmployeeServiceImpl-Create New Employee starting:::");
		Employee empEntity = mapModelToDTO(employeePayload);
		slf4jLogger.info("EmployeeServiceImpl-Create New Employee ending:::");
		return employeeDao.createNewEmployee(empEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.employee.employeeService.service.EmployeeService#updateEmployeeById(
	 * com.employee.employeeService.model.EmployeePayload, java.lang.Long)
	 */
	@Override
	public String updateEmployeeById(EmployeePayload employeePayload, Long id) {
		slf4jLogger.info("EmployeeServiceImpl-update Employee starting:::");
		Employee empEntity = mapModelToDTO(employeePayload);
		slf4jLogger.info("EmployeeServiceImpl-update Employee ending:::");
		return employeeDao.updateEmployeeById(empEntity, id);
	}

	/**
	 * @param employeePayload
	 * @return
	 */
	public Employee mapModelToDTO(EmployeePayload employeePayload) {
		slf4jLogger.info("EmployeeServiceImpl-map model calling:::");
		Employee empEntity = new Employee();
		empEntity.setEmpId(employeePayload.getId());
		empEntity.setEmpName(employeePayload.getName());
		empEntity.setDepartmentName(employeePayload.getDeptName());
		empEntity.setJoiningDate(new Date());
		slf4jLogger.info("EmployeeServiceImpl-map model finished:::");
		return empEntity;

	}

}
