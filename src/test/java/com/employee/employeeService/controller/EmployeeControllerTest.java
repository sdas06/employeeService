package com.employee.employeeService.controller;

import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.employee.employeeService.EmployeeServiceApplication;
import com.employee.employeeService.model.EmployeePayload;
import com.employee.employeeService.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeControllerTest.class);
	@Mock
    EmployeeService employeeServiceMock;
	
	@InjectMocks
    EmployeeController employeeContyroller = new EmployeeController();
	
	/**
	 * 
	 */
	@Test
	public void createNewEmployee(){
		slf4jLogger.info("EmployeeControllerTest -createNewEmployee Starting *******");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		when(employeeServiceMock.createNewEmployee(employeePayload)).thenReturn("Employee Successfully created");
		ResponseEntity<Map<String, Object>> responseEntity = employeeContyroller.createNewEmployee(employeePayload);
		slf4jLogger.info("Getting status value after mocking:::"+responseEntity.getBody().get("status"));
		assertEquals("Employee Successfully created",responseEntity.getBody().get("status"));
		
	} 
	
	@Test
	public void updateEmployeeById(){
		slf4jLogger.info("EmployeeControllerTest -updateEmployeeById Starting *******");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setId(3);
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		
		when(employeeServiceMock.updateEmployeeById(employeePayload, 3l)).thenReturn("Employee Successfully updated");
		ResponseEntity<Map<String, Object>> responseEntity = employeeContyroller.updateEmployeeById(employeePayload, 3l);
		slf4jLogger.info("Getting status value after mocking:::"+responseEntity.getBody().get("status"));
		assertEquals("Employee Successfully updated",responseEntity.getBody().get("status"));
		
	}

}
