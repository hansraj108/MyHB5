package com.hr.config;

import org.springframework.context
.annotation.ComponentScan;
import org.springframework.context
.annotation.Configuration;
import org.springframework.web.servlet
.config.annotation
.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({"com.hr"})

public class MVCconfig
extends WebMvcConfigurerAdapter {
}

