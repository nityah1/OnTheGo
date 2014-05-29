package com.unicorn.mytime.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unicorn.mytime.dao.EmployeeDao;
import com.unicorn.mytime.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired 
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao){
		this.employeeDao = employeeDao;
	}
	
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
	
	public Employee getEmployee(String employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public void deleteEmployee(String employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}


}
