package com.employee.employeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.employee.employeeService.controller.EmployeeController;
import com.employee.employeeService.dao.EmpRepository;
import com.employee.employeeService.entity.Employee;

/**
 * @author sidharth
 *
 */
@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		return factory -> factory.setContextPath("/employeeService");

	}

}

@Component
class empCmdLineRunner implements CommandLineRunner {

	@Autowired
	EmpRepository empRepository;
	final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeServiceApplication.class);
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for (Employee emp : this.empRepository.findAll()) {
			slf4jLogger.info("emp Id->:" + emp.getEmpId());
			slf4jLogger.info("emp Name->:" + emp.getEmpName());
			slf4jLogger.info("joining date-->" + emp.getJoiningDate());
			slf4jLogger.info("Dept Name--->" + emp.getDepartmentName());
			 
		}
	}

}
