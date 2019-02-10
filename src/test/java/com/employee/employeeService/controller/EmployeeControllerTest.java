package com.employee.employeeService.controller;

import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.employee.employeeService.model.EmployeePayload;
import com.employee.employeeService.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	
	@Mock
    EmployeeService employeeServiceMock;
	
	@InjectMocks
    EmployeeController employeeContyroller = new EmployeeController();
	
	@Test
	public void createNewEmployee(){
		System.out.println("Inside testing of EmployeeControllerTest*******");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		when(employeeServiceMock.createNewEmployee(employeePayload)).thenReturn("Employee Successfully created");
		System.out.println(employeeServiceMock.createNewEmployee(employeePayload));
		ResponseEntity<Map<String, Object>> responseEntity = employeeContyroller.createNewEmployee(employeePayload);
		System.out.println("Getting status value:::"+responseEntity.getBody().get("status"));
		assertEquals("Employee Successfully created",responseEntity.getBody().get("status"));
		
	} 
	
	@Test
	public void updateEmployeeById(){
		System.out.println("Inside testing of EmployeeControllerTest2*******");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setId(3);
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		
		when(employeeServiceMock.updateEmployeeById(employeePayload, 3l)).thenReturn("Employee Successfully updated");
		System.out.println(employeeServiceMock.updateEmployeeById(employeePayload, 3l));
		ResponseEntity<Map<String, Object>> responseEntity = employeeContyroller.updateEmployeeById(employeePayload, 3l);
		System.out.println("Getting status value:::"+responseEntity.getBody().get("status"));
		assertEquals("Employee Successfully updated",responseEntity.getBody().get("status"));
		
	}

}
