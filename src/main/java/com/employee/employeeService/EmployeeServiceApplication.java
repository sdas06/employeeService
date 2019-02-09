package com.employee.employeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.employee.employeeService.dao.EmpRepository;
import com.employee.employeeService.entity.Employee;


@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		return factory ->factory.setContextPath("/employeeService");
		
	}

}

@Component
class empCmdLineRunner implements CommandLineRunner{
	
	@Autowired
	EmpRepository empRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for (Employee emp : this.empRepository.findAll()){
			System.out.println("emp Id->:"+emp.getEmpId());
			System.out.println("emp Name->:"+emp.getEmpName());
			System.out.println("joining date-->"+emp.getJoiningDate());
			System.out.println("Dept Name--->"+emp.getDepartmentName());
		}
	}
	
}
 
  

