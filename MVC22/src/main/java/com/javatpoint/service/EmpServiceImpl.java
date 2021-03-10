package com.javatpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatpoint.beans.Emp;
import com.javatpoint.dao.EmpDao;

public class EmpServiceImpl implements EmpService {

	public EmpDao dao;
	
	
	public EmpServiceImpl(EmpDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Emp> fetchAllEmployees() {
		List<Emp> listEmp = dao.getEmployees();
		return listEmp;
	}

	@Override
	public Emp fetchEmployeeById(int id) {
		
		return dao.getEmpById(id);
	}

	@Override
	public String modifyEmployeeById(Emp p) {
		int count=0;
		//use DAO
	   count=dao.update(p);
		if(count==0)
			return "Record not found for updation";
		else
			return "Record  found and updated";
	}

	@Override
	public String removeEmployeeById(int id) {
		int count=0;
		//use DAO
		count=dao.delete(id);
		if(count==0)
			return "Employee not found for Deletion";
		else
			return "Employee  found and Deleted";
	}

	@Override
	public void addNewEmployee(Emp p) {
		int count=0;
		//use DAO
	   dao.save(p);
		
	}

}
