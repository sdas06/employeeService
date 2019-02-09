package com.employee.employeeService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeService.dao.EmpRepository;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.model.EmployeePayload;
import com.employee.employeeService.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private EmployeeService employeeService;

	
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String hello() {
		
		return "Say Helloworld to Employees....";
		
	}
	
	@PostMapping(value="employees" ,consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> createNewEmployee(@RequestBody EmployeePayload employeePayload) {
		System.out.println("emp name :::"+ employeePayload.getName());
		long startTime = System.currentTimeMillis();
		boolean isValidated = validate(employeePayload);
		
		employeeService.createNewEmployee(employeePayload);
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=UTF-8");
	    headers.add("TIme-Taken", String.valueOf(System.currentTimeMillis() - startTime) + " ms");
	    Map<String, Object> json = new HashMap<String, Object>();
	    json.put("status", "Employee Successfully created");
	    return (new ResponseEntity<>(json, headers, HttpStatus.OK));
		
	}
	
	@PutMapping(value="employees/{id}" ,consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> updateEmployeeById(@RequestBody EmployeePayload employeePayload,@PathVariable Long id) {
		long startTime = System.currentTimeMillis();
		
		employeeService.updateEmployeeById(employeePayload,id);
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=UTF-8");
	    headers.add("TIme-Taken", String.valueOf(System.currentTimeMillis() - startTime) + " ms");
	    Map<String, Object> json = new HashMap<String, Object>();
	    json.put("status", "Employee Successfully Updated");
	    return (new ResponseEntity<>(json, headers, HttpStatus.OK)) ;
		
	}

	private boolean validate(EmployeePayload employeePayload) {
		// TODO Auto-generated method stub
		// to validate employeed bean as per xsd
		return false;
	}
	
	 

}
