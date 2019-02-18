package com.employee.employeeService.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sidharth
 *
 */
@Entity
public class Employee {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long empId;
	 private String empName;
	 private String departmentName;
	 private Date	joiningDate;
	 
	 public Employee(String empName) {
			// TODO Auto-generated constructor stub
		 super();
		 this.empName = empName;
		}
	 
	 public Employee() {
		// TODO Auto-generated constructor stub
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Emp id :"+empId+" ,EmpName :"+empName+" ,JoiningDate :"+joiningDate+" ,DepartmentName :"+departmentName;
	}
	

}
