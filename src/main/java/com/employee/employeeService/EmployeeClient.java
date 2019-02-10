package com.employee.employeeService;

import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.employee.employeeService.model.EmployeePayload;

public class EmployeeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
		System.out.println("***Employee Consumer Application****");
		try{
			
			String url = "http://localhost:8080/employeeService/employees";
			System.out.println("Creating New Employee::");
			EmployeePayload employeePayload = new EmployeePayload();
			employeePayload.setName("Anil");
			employeePayload.setDeptName("HR");
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<EmployeePayload> request = new HttpEntity<>(employeePayload);
			ResponseEntity<String> response  = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
			System.out.println("New Employee created with status code: "+response.getStatusCodeValue());
			System.out.println("Updating an existing employee by Id::");
			employeePayload.setName("Akash");
			employeePayload.setDeptName("Finance");
			request = new HttpEntity<>(employeePayload);
			response  = restTemplate.exchange(url+"/3", HttpMethod.PUT, request, String.class);
			System.out.println("Employee with Id 3 is updated with response code :"+response.getStatusCodeValue());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
