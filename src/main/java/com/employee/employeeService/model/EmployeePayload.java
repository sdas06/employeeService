package com.employee.employeeService.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "emp")
public class EmployeePayload {
	
	private String name;
	//@NotNull(message="Id is required field")
	private int id;
	private Date joiningDate;
	private String deptName;
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	@XmlElement
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	@XmlElement
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
