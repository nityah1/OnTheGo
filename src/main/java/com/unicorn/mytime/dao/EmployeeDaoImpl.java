package com.unicorn.mytime.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.unicorn.mytime.model.Employee;
 

@Repository
@Component("employeeDao")
public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao  {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addEmployee(Employee employee) {
    	// set default values
    	String defPass = "password";
    	employee.setStartDate(new Date(System.currentTimeMillis()));
		employee.setPassword(defPass);
		employee.setHashedPassword(defPass.hashCode()+"");
		employee.setLocked(false);
		
		// Save
        this.sessionFactory.getCurrentSession().save(employee);
    }
 

	public void updateEmployee(Employee employee) {
        this.sessionFactory.getCurrentSession().update(employee);
		
	}
	
	@SuppressWarnings("unchecked")
	public Employee getEmployee(String employeeId){
		System.out.println("In DAO class");
		try{
			return (Employee) getCurrentSession().get(Employee.class,employeeId);
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
        return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
    } 
    
    public void deleteEmployee(String employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (employee != null) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }


}