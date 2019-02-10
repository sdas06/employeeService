package com.employee.employeeService.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "emp")
public class EmployeePayload {
	
	@NotNull(message="Name is required field")
	@Size(min = 2, max = 30)
	private String name;
	private int id;
	private Date joiningDate;
	@NotNull(message="Department is required field")
	@Pattern(regexp = "hr|fin|it|operations", flags = Pattern.Flag.CASE_INSENSITIVE)
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
