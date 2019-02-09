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
			EmployeePayload employeePayload = new EmployeePayload();
			employeePayload.setName("Anil");
			employeePayload.setId(1234);
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<EmployeePayload> request = new HttpEntity<>(employeePayload);
			ResponseEntity<String> response  = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
			System.out.println(response.getStatusCodeValue());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
