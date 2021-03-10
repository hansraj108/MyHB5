package com.hr.net.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="ForeignKeyAssoEEntity")
@Table(name="EMPLOYEE20", uniqueConstraints = {@UniqueConstraint(columnNames = "ID"),
												@UniqueConstraint(columnNames = "EMAIL")})
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique = true, nullable = false)
	private Integer employeeId;
	
	@Column(name="EMAIL", unique = true, nullable = false, length = 100)
	private String email;
	
	@Column(name="FIRST_NAME", unique = false, nullable = false, length = 100)
	private String firstName;
	
	@Column(name="LAST_NAME", unique = false, nullable = false, length = 100)
	private String lastName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Set<Account> accounts;
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	
	
}
