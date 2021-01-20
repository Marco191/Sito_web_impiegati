package com.nttdata.EmployeeApp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@EnableScheduling
public class EmployeeApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApp2Application.class, args);
	}
	 

}
