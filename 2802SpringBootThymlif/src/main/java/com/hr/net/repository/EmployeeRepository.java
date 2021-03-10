package com.hr.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.net.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
