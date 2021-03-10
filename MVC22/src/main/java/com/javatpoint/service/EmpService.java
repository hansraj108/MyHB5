package com.javatpoint.service;

import java.util.List;

import com.javatpoint.beans.Emp;

public interface EmpService {

	public abstract List<Emp> fetchAllEmployees(); 
	public abstract Emp fetchEmployeeById(int id);
	public abstract  String modifyEmployeeById(Emp p);
	public abstract  String  removeEmployeeById(int id);
	public abstract  void addNewEmployee(Emp p);
}
