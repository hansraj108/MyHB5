package com.hr.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hr.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql = "INSERT INTO user (`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES (?,?,?,?,?,?)";
		Object[] param = new Object[] {"hans1888","123","asd@gmail.com","nvs","v12","v12"};
		jt.update(sql, param);
		System.out.println("-----------SQL Executed-----------");
		
	}
}