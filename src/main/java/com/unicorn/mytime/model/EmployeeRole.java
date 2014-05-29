package com.unicorn.mytime.model;

import javax.persistence.*;

@Entity
@Table(name="Employee_Role")
public class EmployeeRole {

	@Id
    @Column(name="Id")
    @GeneratedValue
	private Integer roleId;
	@Column(name="EmployeeId")
	private String employeeId;
	private String roleName;
	
	
	
	
	
}
