package com.employee.employeeService.dao;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.employeeService.entity.Employee;

/**
 * @author sidharth
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	EmpRepository empRepository;
	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.employee.employeeService.dao.EmployeeDao#createNewEmployee(com.
	 * employee.employeeService.entity.Employee)
	 */
	@Override
	public String createNewEmployee(Employee employeeEntity) {
		slf4jLogger.info("EmployeeDaoImpl-Create New Employee starting:::");
		try {
			empRepository.save(employeeEntity);

			List<Employee> empList = empRepository.findAll();
			for (Employee empEnt : empList) {
				slf4jLogger.info("*******Displaying Employees Details******");
				slf4jLogger.info("Emp Name****" + empEnt.getEmpName());
				slf4jLogger.info("Emp ID****" + empEnt.getEmpId());
				slf4jLogger.info("Dept Name****" + empEnt.getDepartmentName());
				slf4jLogger.info("Joining Date***" + empEnt.getJoiningDate());
			}
		} catch (Exception e) {
			slf4jLogger.error("Exception occured while creating Employee information:: {}", e.getMessage());
		}
		slf4jLogger.info("EmployeeDaoImpl-Create New Employee ending:::");
		return "Employee Created Successfully";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.employee.employeeService.dao.EmployeeDao#updateEmployeeById(com.
	 * employee.employeeService.entity.Employee, java.lang.Long)
	 */
	@Override
	public String updateEmployeeById(Employee employeeEntity, Long id) {
		// TODO Auto-generated method stub
		slf4jLogger.info("EmployeeDaoImpl-Create update Employee starting:::");
		String status = null;
		try {
			Employee emp = (Employee) empRepository.findByEmpId(id);
			if (null != emp) {
				slf4jLogger.info("Employee Name for given Emp id {} is {}",id,emp.getEmpName());
				Date dateOne = emp.getJoiningDate();
				Date dateTwo = employeeEntity.getJoiningDate();

				long dateDifference = dateTwo.getTime() - dateOne.getTime();
				System.out.println("The date difference in milliseconds-->" + dateDifference);
				if (dateDifference > (24 * 60 * 60 * 1000)) {
					slf4jLogger.info("Employee updation after 24 hours");
					employeeEntity.setEmpId(emp.getEmpId());
					empRepository.save(employeeEntity);
					status = "Employee Updated successfully";
				} else {
					slf4jLogger.info("Employee updation before 24 hours");
					status = "Employee Updation is restricted";
				}

				List<Employee> empList = empRepository.findAll();
				for (Employee empEnt : empList) {
					slf4jLogger.info("*******Displaying Employees Details******");
					slf4jLogger.info("Emp Name****" + empEnt.getEmpName());
					slf4jLogger.info("Emp ID****" + empEnt.getEmpId());
					slf4jLogger.info("Dept Name****" + empEnt.getDepartmentName());
					slf4jLogger.info("Joining Date***" + empEnt.getJoiningDate());
				}
			} else {
				slf4jLogger.info("No Employee exist with given Id");
				status = "Employee Updated Unsuccessfully";
			}
		} catch (Exception e) {
			slf4jLogger.error("Exception occured while updating Employee information:: {}", e.getMessage());
		}
		slf4jLogger.info("EmployeeDaoImpl-Create update Employee ending:::");
		return status;

	}

}
