package com.employee.employeeService;

import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
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
			
			////////////////////////////////////////////////////////////
			//  Test case-1 - Creating Employee with correct input
			System.out.println("************Test case-1 - Creating Employee with correct input **********");
			EmployeePayload empPayload = new EmployeePayload();
			empPayload.setName("Anil");
			empPayload.setDeptName("HR");
			EmployeeClient.createNewEmployee(url,empPayload);
			
		//  Test case-2 - Creating Employee with incorrect input (Name as single character)
			System.out.println("************Test case-2 - CCreating Employee with incorrect input (Name as single character and dept as other **********");
			empPayload.setName("A");
			empPayload.setDeptName("Other");
			EmployeeClient.createNewEmployee(url,empPayload);
			
		//  Test case-3 - Updating Employee with incorrect input (Name as single character)
			System.out.println("************Test case-3 - Updating  Employee with a given id **********");
			empPayload.setName("Akash");
			empPayload.setDeptName("Fin");
			int id = 3;
			EmployeeClient.updateEmployeeById(url+"/"+id,empPayload);
			
			//Test case-4 - Updating Employee with incorrect input (Name as single character)
			System.out.println("************Test case-4 - Updating  Employee with incorrect input (Name as single character) **********");
			empPayload.setName("A");
			empPayload.setDeptName("Other");
			EmployeeClient.updateEmployeeById(url+"/"+id,empPayload);
			
		}catch(HttpClientErrorException e){
			System.out.println(e.getResponseBodyAsString());
			//e.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		

	}

	private static void updateEmployeeById(String url, EmployeePayload employeePayload) {
		// TODO Auto-generated method stub
		try{
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<EmployeePayload> request = new HttpEntity<>(employeePayload);
			ResponseEntity<String> response  = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
			System.out.println("Employee with Id 3 is updated with response code :"+response.getStatusCodeValue());
		}catch(HttpClientErrorException e){
			System.out.println("Employee Updation Unsuccessful:::");
			System.out.println(e.getResponseBodyAsString());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	private static void createNewEmployee(String url, EmployeePayload employeePayload) {
		// TODO Auto-generated method stub
		try{
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<EmployeePayload> request = new HttpEntity<>(employeePayload);
			ResponseEntity<String> response  = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
			System.out.println("New Employee created with status code: "+response.getStatusCodeValue());
		}catch(HttpClientErrorException e){
			System.out.println("Employee Creation Unsuccessful:::");
			System.out.println(e.getResponseBodyAsString());
		}catch(Exception e){
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
	}

}
