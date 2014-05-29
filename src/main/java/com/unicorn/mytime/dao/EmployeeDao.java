package com.unicorn.mytime.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.unicorn.mytime.model.Employee;


public interface EmployeeDao {

	public void addEmployee(Employee employee);   
	public void updateEmployee(Employee employee);
	public Employee getEmployee(String employeeId);
    public List<Employee> getAllEmployees(); 
    public void deleteEmployee(String employeeId);
    
    //Hibernate properties valus ==> hibernate.connection.provider_class=org.hibernate.connection.C3P0ConnectionProvider
}
