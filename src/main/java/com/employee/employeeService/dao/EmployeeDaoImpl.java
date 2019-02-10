package com.employee.employeeService.dao;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.employeeService.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	EmpRepository empRepository;
	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Override
	public String createNewEmployee(Employee employeeEntity) {
		// TODO Auto-generated method stub
		slf4jLogger.info("EmployeeDaoImpl-Create New Employee starting:::");
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
		slf4jLogger.info("EmployeeDaoImpl-Create New Employee ending:::");
		return "Employee Created Successfully";
	}

	@Override
	public String updateEmployeeById(Employee employeeEntity, Long id) {
		// TODO Auto-generated method stub
		slf4jLogger.info("EmployeeDaoImpl-Create update Employee starting:::");
		String status = null;
		try{
			Employee emp = (Employee) empRepository.findByEmpId(id);
			if (null != emp){
				System.out.println("the emp name for the id-->"+emp.getEmpName());
				Date dateOne = emp.getJoiningDate();
				Date dateTwo = employeeEntity.getJoiningDate();
				
				
				long dateDifference = dateTwo.getTime() - dateOne.getTime();
				System.out.println("The date difference in milliseconds-->"+dateDifference);
				if (dateDifference > (24*60*60*1000)){
					System.out.println("More than 24 hours");
					employeeEntity.setEmpId(emp.getEmpId());
					empRepository.save(employeeEntity);
					status = "Employee Updated successfully";
				}
				else{
					System.out.println("Less than 24 hours");
					status = "Employee Updation is restricted";
				}
					
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
		slf4jLogger.info("EmployeeDaoImpl-Create update Employee ending:::");
		return status;
		
	}

}
