package com.spring.studentmanagement.pojo;

import org.springframework.stereotype.Component;

@Component("student")
public class Student {
	
	private int studentId;
	private String studentFirstName;
	private String studentLastName;
	private String studentEmailId;
	private String logonPassword;
	
	
	public Student() {
		super();
	}


	public Student(int studentId, String studentFirstName, String studentLastName, String studentEmailId,
			String logonPassword) {
		super();
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentEmailId = studentEmailId;
		this.logonPassword = logonPassword;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentFirstName() {
		return studentFirstName;
	}


	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}


	public String getStudentLastName() {
		return studentLastName;
	}


	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}


	public String getStudentEmailId() {
		return studentEmailId;
	}


	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}


	public String getLogonPassword() {
		return logonPassword;
	}


	public void setLogonPassword(String logonPassword) {
		this.logonPassword = logonPassword;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", studentEmailId=" + studentEmailId + ", logonPassword=" + logonPassword + "]";
	}


	
	

	
}
