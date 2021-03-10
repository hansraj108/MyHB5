package com.hr.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.hr.dao","com.hr.service"})
@PropertySource(value = { "classpath:jdbc.properties" })
public class SpringRootConfig {

	@Autowired
    private Environment environment;
	//ds, dao, service, special beans
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		ds.setUrl(environment.getRequiredProperty("jdbc.url"));
        ds.setUsername(environment.getRequiredProperty("jdbc.username"));
        ds.setPassword(environment.getRequiredProperty("jdbc.password"));
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery(environment.getRequiredProperty("jdbc.setValidationQuery"));
        ds.setDefaultAutoCommit(true);
        return ds;
		
	}
}
