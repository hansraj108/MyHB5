package com.javatpoint.dao;

import java.util.List;

import com.javatpoint.beans.Emp;

public interface EmpDao {

	//to save indiaviual data
	public abstract void save(Emp p);
	
	//to update a record by its id
	public abstract void update(Emp p);
	
	//to delete a record by id
	public abstract void delete(int id);
	
	//retrieve a record by id
	public abstract Emp getEmpById(int id);
	
	//retrieve all employees
	public abstract List<Emp> getEmployees();
	
}
