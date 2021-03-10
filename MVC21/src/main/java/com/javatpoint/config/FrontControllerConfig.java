package com.javatpoint.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { SpringRootConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
	}
	
/*Set these variables for your project needs*/ 
    
	private static final String LOCATION = "C:/mytemp/";

	private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
	
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 60;//30MB

    private static final int FILE_SIZE_THRESHOLD = 0;
	
}
