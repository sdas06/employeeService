package com.employee.employeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.employee.employeeService.model.EmployeePayload;

public class EmployeeClient {

	static boolean retry = true;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("***Employee Client Application****");

		String url = "http://localhost:8080/employeeService/employees";

		////////////////////////////////////////////////////////////
		// Test case-1 - Creating Employee with proper input
		System.out.println();
		System.out.println("************/n Test case-1 - Creating Employee with correct input **********");
		EmployeePayload empPayload = new EmployeePayload();
		empPayload.setName("Anil");
		empPayload.setDeptName("HR");
		EmployeeClient.createNewEmployee(url, empPayload);

		// Test case-2 - Creating Employee with improper input (Name as single
		// character and invalid depname)
		System.out.println();
		System.out.println(
				"************Test case-2 - Creating Employee with incorrect input (Name as single character and dept as other **********");
		empPayload.setName("A");
		empPayload.setDeptName("Other");
		EmployeeClient.createNewEmployee(url, empPayload);

		// Test case-3 - Updating Employee with correct input
		System.out.println();
		System.out.println("************Test case-3 - Updating  Employee with a given id **********");
		empPayload.setName("Akash");
		empPayload.setDeptName("Fin");
		int id = 3;
		EmployeeClient.updateEmployeeById(url + "/" + id, empPayload);

		// Test case-4 - Updating Employee with incorrect input (Name as single
		// character and invalid depname)
		System.out.println();
		System.out.println(
				"************Test case-4 - Updating  Employee with incorrect input (Name as single character) **********");
		empPayload.setName("A");
		empPayload.setDeptName("Other");
		EmployeeClient.updateEmployeeById(url + "/" + id, empPayload);

	}

	private static void updateEmployeeById(String url, EmployeePayload employeePayload) {
		// TODO Auto-generated method stub
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<EmployeePayload> request = new HttpEntity<>(employeePayload);
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
			System.out.println("Employee with Id 3 is updated with response code :" + response.getStatusCodeValue());
		} catch (HttpClientErrorException e) {
			retry = true;
			System.out.println("Employee Updation Unsuccessful:::");
			System.out.println(e.getResponseBodyAsString());
		} catch (Exception e) {
			retry = true;
			count = count + 1;
			System.out.println(e.getMessage());
			System.out.println("generic exception");
			if (count < 4) System.out.println("retry count is " + count);
			if (count <= 3) {
				try {
					Thread.sleep(10 * 1000);
					EmployeeClient.updateEmployeeById(url, employeePayload);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				System.out.println("\nRetry Failed: Total Retry attemps made " + (count-1)
						+ " at interval of 10000 ms\n\n");
				count = 0;
			}

		}

	}

	private static void createNewEmployee(String url, EmployeePayload employeePayload) throws Exception {
		// TODO Auto-generated method stub
		try {
			System.out.println("****Invoking Rest Service******");
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<EmployeePayload> request = new HttpEntity<>(employeePayload);
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
			System.out.println("New Employee created with status code: " + response.getStatusCodeValue());
		} catch (HttpClientErrorException e) {
			retry = true;
			System.out.println("Employee Creation Unsuccessful:::");
			System.out.println(e.getResponseBodyAsString());
		} catch (Exception e) {
			retry = true;
			count = count + 1;

			System.out.println("generic exception");
			if (count < 4) System.out.println("retry count is " + count);
			if (count <= 3) {
				try {
					Thread.sleep(10 * 1000);
					EmployeeClient.createNewEmployee(url, employeePayload);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				System.out.println("\nRetry Failed: Total Retry attemps made " + (count-1)
						+ " at interval of 10000 ms\n\n");
				count = 0;
			}

			System.out.println(e.getMessage());
		}

	}

}
