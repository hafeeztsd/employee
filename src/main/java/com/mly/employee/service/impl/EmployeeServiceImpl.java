package com.mly.employee.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mly.employee.config.Properties;
import com.mly.employee.model.Employee;
import com.mly.employee.service.EmployeeService;
import com.mly.employee.service.Observable;
import com.mly.employee.service.Observer;

@Service
public class EmployeeServiceImpl implements EmployeeService, Observable {

	private static final String EMPTY_VALUE = "";
	private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class.getName());
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private Path file;
	private File employeeFile;
	private List<Employee> employees = new ArrayList<>();
	private AtomicInteger idGenerator;
	private List<Observer> observers = new ArrayList<>();
	private String message;

	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.receive(message);
		}
	}

	@Override
	public Employee createEmployee(Employee employee) {
		employee.setId(idGenerator.incrementAndGet());
		employees.add(employee);
		writeEmployees();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		int index = employees.indexOf(employee);
		if (index < 0) {
			return null;
		}
		employees.set(index, employee);
		writeEmployees();
		return employees.get(index);
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		boolean removed = employees.remove(new Employee(id));
		if (removed) {
			writeEmployees();
			message = "Employee wih ID = " + id + " deleted successfully";
			notifyObservers();
		}
		return removed;
	}

	@Override
	public Employee findEmployeeById(int id) {
		int index = employees.indexOf(new Employee(id));
		if (index > -1) {
			return employees.get(index);
		}
		return null;
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employees;
	}

	@Autowired
	private Properties properties;

	@PostConstruct
	public void init() {
		LOGGER.info(String.valueOf(properties));
		String dir = properties.getFiledir();
		String fileName = properties.getFilename();
		String path = dir + fileName;
		employeeFile = new File(path);
		file = Paths.get(path);
		try {
			if (!employeeFile.exists()) {
				boolean created = false;
				created = employeeFile.createNewFile();
				idGenerator = new AtomicInteger(0);
				writeEmployees();
				LOGGER.info(" File  " + path + " created successfully " + created);
			} else {
				readEmployees();
				idGenerator = new AtomicInteger(employees.size());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void writeEmployees() {
		try {
			Files.write(file, MAPPER.writeValueAsBytes(EMPTY_VALUE), StandardOpenOption.CREATE);
			Files.write(file, MAPPER.writeValueAsBytes(employees), StandardOpenOption.CREATE);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void readEmployees() {
		try {
			Class<?> clz = Class.forName(Employee.class.getCanonicalName());
			JavaType type = MAPPER.getTypeFactory().constructCollectionType(List.class, clz);
			employees = MAPPER.readValue(employeeFile, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
