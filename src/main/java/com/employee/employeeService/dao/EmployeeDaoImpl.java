package com.employee.employeeService.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.model.EmployeePayload;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	EmpRepository empRepository;

	@Override
	public String createNewEmployee(Employee employeeEntity) {
		// TODO Auto-generated method stub
		
		try{
			empRepository.save(employeeEntity);
			System.out.println("In DaoImpl*******************************");
			List<Employee> empList =empRepository.findAll();
			for (Employee empEnt : empList){
				System.out.println("Emp Name****"+empEnt.getEmpName());
				System.out.println("Emp ID****"+empEnt.getEmpId());
				System.out.println("Dept Name****"+empEnt.getDepartmentName());
				System.out.println("Joining Date***"+empEnt.getJoiningDate());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Employee Created Successfully:::";
	}

	@Override
	public String updateEmployeeById(Employee employeeEntity, Long id) {
		// TODO Auto-generated method stub
		String status = null;
		try{
			Employee emp = (Employee) empRepository.findByEmpId(id);
			if (null != emp){
				System.out.println("the emp name for the id-->"+emp.getEmpName());
				employeeEntity.setEmpId(emp.getEmpId());
				empRepository.save(employeeEntity);
				status = "Employee Updated successfully";
				
				System.out.println("In DaoImpl*******************************");
				List<Employee> empList =empRepository.findAll();
				for (Employee empEnt : empList){
					System.out.println("Emp Name****"+empEnt.getEmpName());
					System.out.println("Emp ID****"+empEnt.getEmpId());
					System.out.println("Dept Name****"+empEnt.getDepartmentName());
					System.out.println("Joining Date***"+empEnt.getJoiningDate());
				}
			}else{
				System.out.println("No Employee exist with given Id");
				status = "Employee Updated Unsuccessfully";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
		
	}

}
