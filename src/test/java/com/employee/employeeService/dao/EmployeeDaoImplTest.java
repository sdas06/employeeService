package com.employee.employeeService.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.employee.employeeService.EmployeeServiceApplication;
import com.employee.employeeService.dao.EmpRepository;
import com.employee.employeeService.dao.EmployeeDaoImpl;
import com.employee.employeeService.entity.Employee;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeDaoImplTest {
	
	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeDaoImplTest.class);
	
	@Mock
	EmpRepository empRepositoryMock;
	
	@InjectMocks
	EmployeeDaoImpl employeeDaoImpl;
	
	@Test
	public void createNewEmployee(){
		slf4jLogger.info("***EmployeeDaoImplTest -createNewEmployee starting");
		Employee employee = new Employee();
		employee.setEmpName("Rajesh");
		employee.setDepartmentName("HR");
		employee.setJoiningDate(new Date());
				
		when(empRepositoryMock.save(Mockito.any())).thenReturn(employee);
		String status = employeeDaoImpl.createNewEmployee(employee);
		slf4jLogger.info("status after mocking"+status);
		assertEquals("Employee Created Successfully",status);
		
	}
	
	@Test
	public void updateEmployeeById(){
		slf4jLogger.info("***EmployeeDaoImplTest -updateEmployeeById starting");
		Employee employee = new Employee();
		employee.setEmpName("Rajesh");
		employee.setDepartmentName("HR");
		employee.setJoiningDate(new Date());
		
		when(empRepositoryMock.save(Mockito.any())).thenReturn(employee);
		
		Employee employee2 = new Employee();
		employee2.setEmpName("Rakesh");
		employee2.setDepartmentName("IT");
		employee2.setJoiningDate(new Date());
		
		when(empRepositoryMock.findByEmpId(Mockito.anyLong())).thenReturn(employee);
		String status = employeeDaoImpl.updateEmployeeById(employee, 3l);
		slf4jLogger.info("status after mocking"+status);
		assertEquals("Employee Updation is restricted",status);
		
	}
	 

}
