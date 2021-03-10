package com.jwt.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.EmployeeDAO;
import com.jwt.model.Employee;
import com.jwt.util.DateConversion;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeDAO employeeDAO;
 
    @Override
    @Transactional
    public void addEmployee(Employee employee) {
		/*
		 * java.util.Date utilDob = employee.getDob(); java.sql.Date sqlDob =
		 * DateConversion.sqlDate(utilDob); employee.setDob(sqlDob);
		 */
        employeeDAO.addEmployee(employee);
    }
 
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
 
    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
 
    public Employee getEmployee(int empid) {
    	Employee emp = employeeDAO.getEmployee(empid);
		/*
		 * java.sql.Date utilDate = DateConversion.utilDate(emp.getDob());
		 * 
		 * 
		 * emp.setDob(uDate);
		 */
        return emp;
    }
 
    public Employee updateEmployee(Employee employee) {
    	java.util.Date utilDob = employee.getDob();
    	java.sql.Date sqlDob = DateConversion.sqlDate(utilDob);
    	employee.setDob(sqlDob);
        return employeeDAO.updateEmployee(employee);
    }
 
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
 
}