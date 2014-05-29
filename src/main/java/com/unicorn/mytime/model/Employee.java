package com.unicorn.mytime.model;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="Employees")
public class Employee {

	@Id
	@Column(name="EmployeeId")
	@Size(min=5, max=7)
	@NotNull
	private String employeeId;
	@Column(name="Password")
	@NotNull
	private String password;
	@Column(name="HashedPassword")
	private String hashedPassword;
	@Column(name="FirstName")
	@NotNull
	@Size(min=2, max=20)
	private String firstName;
	@Column(name="Surname")
	@NotNull
	@Size(min=2, max=20)
	private String surname;
	@Column(name="ContactPhone")
	private String contactPhone;
	@Column(name="HomeAddress")
	private String homeAddress;
	@Column(name="StartDate") 
	private Date startDate;
	@Column(name="EndDate")
	private Date endDate;
	@Column(name="HourlyRate")
	private Double hourlyRate;
	@Column(name="LastLoggedIn")
	private Date lastLoggedIn;
	@Column(name="isLocked")
	private char isLocked;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	public Date getLastLoggedIn() {
		return lastLoggedIn;
	}
	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}
	public char isLocked() {
		return this.isLocked;
	}
	
	public boolean isLockedBool() {
		return (this.isLocked == 'N' ? false : true);
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked ? 'Y':'N';
	}
	
	
}
