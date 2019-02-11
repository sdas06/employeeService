package com.employee.employeeService.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.employee.employeeService.model.EmployeePayload;
import com.employee.employeeService.service.EmployeeService;

/**
 * 
 * @author sidharth
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeController.class);

	/**
	 * @return
	 */
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello() {

		return "Say Hello to Employees....";

	}

	/**
	 * @param employeePayload
	 * @return
	 */
	@PostMapping(value = "employees", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> createNewEmployee(@Valid @RequestBody EmployeePayload employeePayload) {

		slf4jLogger.info("EmployeeController-Create New Employee starting:::");
		long startTime = System.currentTimeMillis();

		String status = employeeService.createNewEmployee(employeePayload);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("TIme-Taken", String.valueOf(System.currentTimeMillis() - startTime) + " ms");
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("status", status);
		slf4jLogger.info("EmployeeController-Create New Employee ending:::");
		return (new ResponseEntity<>(json, headers, HttpStatus.CREATED));

	}

	/**
	 * 
	 * @param employeePayload
	 * @param id
	 * @return
	 */
	@PutMapping(value = "employees/{id}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> updateEmployeeById(@Valid @RequestBody EmployeePayload employeePayload,
			@PathVariable Long id) {

		slf4jLogger.info("EmployeeController-Update Employee starting:::");
		long startTime = System.currentTimeMillis();
		String status = employeeService.updateEmployeeById(employeePayload, id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("TIme-Taken", String.valueOf(System.currentTimeMillis() - startTime) + " ms");
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("status", status);
		slf4jLogger.info("EmployeeController-Update Employee ending:::");
		return (new ResponseEntity<>(json, headers, HttpStatus.OK));

	}

}
