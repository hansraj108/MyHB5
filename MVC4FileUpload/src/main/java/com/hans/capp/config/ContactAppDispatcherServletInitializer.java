package com.hans.capp.config;



import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ContactAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringRootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
	}
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    	registration.setMultipartConfig(getMultipartConfigElement());
	}
	
	private MultipartConfigElement getMultipartConfigElement(){
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}
	
	 /*Set these variables for your project needs*/ 
    
		private static final String LOCATION = "C:/mytemp/";

		private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
		
		private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB

	    private static final int FILE_SIZE_THRESHOLD = 0;
}