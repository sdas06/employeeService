package com.employee.employeeService.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.employee.employeeService.dao.EmpRepository;
import com.employee.employeeService.dao.EmployeeDaoImpl;
import com.employee.employeeService.entity.Employee;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeDaoImplTest {
	
	@Mock
	EmpRepository empRepositoryMock;
	
	@InjectMocks
	EmployeeDaoImpl employeeDaoImpl;
	
	@Test
	public void createNewEmployee(){
		Employee employee = new Employee();
		employee.setEmpName("Rajesh");
		employee.setDepartmentName("HR");
		employee.setJoiningDate(new Date());
				
		when(empRepositoryMock.save(Mockito.any())).thenReturn(employee);
		String status = employeeDaoImpl.createNewEmployee(employee);
		System.out.println("DaoTest "+status);
		assertEquals("Employee Created Successfully",status);
		
	}
	
	@Test
	public void updateEmployeeById(){
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
		System.out.println("DaoTest2 "+status);
		assertEquals("Employee Updation is restricted",status);
		
	}
	 

}
