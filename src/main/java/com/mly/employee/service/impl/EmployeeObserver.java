package com.mly.employee.service.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.mly.employee.service.Observable;
import com.mly.employee.service.Observer;

@Service
public class EmployeeObserver implements Observer {

	private static Logger LOGGER = Logger.getLogger(EmployeeObserver.class.getName());

	public EmployeeObserver(Observable observable) {
		observable.register(this);
	}

	@Override
	public void receive(String message) {
		LOGGER.info(message);
	}

}
