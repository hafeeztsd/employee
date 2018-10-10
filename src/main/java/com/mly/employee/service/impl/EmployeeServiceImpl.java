package com.mly.employee.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mly.employee.config.Properties;
import com.mly.employee.model.Employee;
import com.mly.employee.service.EmployeeService;
import com.mly.employee.util.IDGenerator;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class.getName());
	private static final ObjectMapper MAPPER = new ObjectMapper();

	private Path file;

	@Override
	public int createEmployee(Employee employee) {
		try {
			employee.setId(IDGenerator.generate());
			String json = MAPPER.writeValueAsString(employee);
		} catch (Exception e) {
			throw new RuntimeException("Error while adding " + employee);
		}
		return 0;
	}

	@Override
	public List<Employee> findAll() {
		return null;
	}

	@Autowired
	private Properties properties;

	@PostConstruct
	public void init() {
		LOGGER.info(String.valueOf(properties));
		String dir = properties.getFiledir();
		String fileName = properties.getFilename();
		String path = dir + "\\" + fileName;
		File employeeFile = new File(path);
		if (!employeeFile.exists()) {
			boolean created = false;
			try {
				created = employeeFile.createNewFile();
				file = Paths.get(path);
				Files.write(file, "[]".getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				throw new RuntimeException("Error while creating file: " + e.getMessage());
			}
			LOGGER.info(" File  " + path + " created successfully " + created);

		}
	}

}
