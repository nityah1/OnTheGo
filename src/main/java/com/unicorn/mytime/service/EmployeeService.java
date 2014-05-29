package com.unicorn.mytime.service;

import java.util.List;

import com.unicorn.mytime.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee getEmployee(String employeeId);
	public List<Employee> getAllEmployees(); 
    public void deleteEmployee(String employeeId);
	

}
