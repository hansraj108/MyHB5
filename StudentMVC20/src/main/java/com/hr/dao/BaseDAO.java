package com.hr.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public abstract class BaseDAO extends NamedParameterJdbcDaoSupport{
	
	@Autowired
	public void setDataSource1(DataSource ds) {
		super.setDataSource(ds);
		
	}
	
	

}
