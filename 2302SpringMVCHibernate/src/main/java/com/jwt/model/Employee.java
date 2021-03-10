package com.jwt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_TBL")
public class Employee implements Serializable {
 
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    @Column
    private String name;
    
	
	  @Column // @DateTimeFormat(pattern="dd/MM/yyyy")
	//  @Temporal(TemporalType.DATE) 
	  // @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	 
    @Column
    private String email;
 
    @Column
    private String address;
 
    @Column
    private String telephone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	  public Date getDob() { return dob; }
	  
	  public void setDob(Date dob) { this.dob = dob; }
	 
	 	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
 
    
}