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
import com.employee.employeeService.dao.EmployeeDao;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.model.EmployeePayload;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	
	@Mock
	EmployeeDao employeeDao;
	
	 
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Test
	public void createNewEmployee(){
		System.out.println("Inside testing of EmployeeServiceImplTest*******");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		Employee empEntity = employeeServiceImpl.mapModelToDTO(employeePayload);
		System.out.println("employeeEntity--->"+empEntity);
		
		when(employeeDao.createNewEmployee(Mockito.any())).thenReturn("Employee Successfully created");
		//when(employeeServiceImpl.mapModelToDTO(employeePayload)).thenReturn(empEntity);
		//System.out.println(employeeDao.createNewEmployee(empEntity));
		String status = employeeServiceImpl.createNewEmployee(employeePayload);
		System.out.println("Getting status value:::"+status);
		assertEquals("Employee Successfully created",status);
		
	} 
	
	@Test
	public void updateEmployeeById(){
		System.out.println("Inside testing of EmployeeServiceImplTest - update*******");
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		Employee empEntity = employeeServiceImpl.mapModelToDTO(employeePayload);
		System.out.println("employeeEntity--->"+empEntity);
		
		when(employeeDao.updateEmployeeById(Mockito.any(),Mockito.any())).thenReturn("Employee Successfully updated");
		//when(employeeServiceImpl.mapModelToDTO(employeePayload)).thenReturn(empEntity);
		//System.out.println(employeeDao.createNewEmployee(empEntity));
		String status = employeeServiceImpl.updateEmployeeById(employeePayload,3l);
		System.out.println("Getting status value for update:::"+status);
		assertEquals("Employee Successfully updated",status);
		
	}
	
	@Test
	public void mapModelToDTO() {
		EmployeePayload employeePayload = new EmployeePayload();
		employeePayload.setName("Rajesh");
		employeePayload.setDeptName("HR");
		employeePayload.setJoiningDate(new Date());
		Employee empEntity = employeeServiceImpl.mapModelToDTO(employeePayload);
		assertEquals("Rajesh",empEntity.getEmpName());
		assertEquals("HR",empEntity.getDepartmentName());
		
	}

}
