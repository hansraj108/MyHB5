package com.hr.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.net.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
