package com.mly.employee.service;

public interface Observable {

	void register(Observer observer);

	void notifyObservers();
}
