package com.employee.employeeService.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.employee.employeeService.dao.EmployeeDao;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.model.EmployeePayload;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	
	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeServiceImplTest.class);
	
	@Mock
	EmployeeDao employeeDao;
	
	 
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Test
	public void createNewEmployee(){
		slf4jLogger.info("***EmployeeServiceImplTest -createNewEmployee starting ");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		
		when(employeeDao.createNewEmployee(Mockito.any())).thenReturn("Employee Successfully created");
		String status = employeeServiceImpl.createNewEmployee(employeePayload);
		slf4jLogger.info("Getting status value after mocking:::"+status);
		assertEquals("Employee Successfully created",status);
		
	} 
	
	@Test
	public void updateEmployeeById(){
		slf4jLogger.info("***EmployeeServiceImplTest -updateEmployeeById starting ");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		
		when(employeeDao.updateEmployeeById(Mockito.any(),Mockito.any())).thenReturn("Employee Successfully updated");
		String status = employeeServiceImpl.updateEmployeeById(employeePayload,3l);
		slf4jLogger.info("Getting status value after mocking:::"+status);
		assertEquals("Employee Successfully updated",status);
		
	}
	
	@Test
	public void mapModelToDTO() {
		slf4jLogger.info("***EmployeeServiceImplTest -mapModelToDTO starting ");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		Employee empEntity = employeeServiceImpl.mapModelToDTO(employeePayload);
		assertEquals("Rajesh",empEntity.getEmpName());
		assertEquals("HR",empEntity.getDepartmentName());
		
	}

}
