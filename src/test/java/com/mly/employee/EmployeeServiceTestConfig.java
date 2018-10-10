package com.mly.employee;

import java.io.File;
import java.util.logging.Logger;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mly.employee.config.Properties;
import com.mly.employee.service.EmployeeService;

@Configuration
@ComponentScan(basePackageClasses = { EmployeeService.class })
public class EmployeeServiceTestConfig {

	private static final String EMPLOYEE_JSON = "employee.json";
	private static final String USER_DIR = "user.dir";
	private static final Logger LOGGER = Logger.getLogger(EmployeeServiceTestConfig.class.getName());
	private Properties properties;
	
	@Bean
	public Properties properties() {
		properties = new Properties();
		properties.setFiledir(System.getProperty(USER_DIR));
		properties.setFilename(EMPLOYEE_JSON);
		return properties;
	}

	@PreDestroy
	public void cleanUp() {
		LOGGER.info("Deleting test generated file....");
		String dir = properties.getFiledir();
		String fileName = properties.getFilename();
		String path = dir + "\\" + fileName;
		File employeeFile = new File(path);
		boolean deleted = employeeFile.delete();
		LOGGER.info("test file deleted successfully " + deleted);
		
	}
	
}
