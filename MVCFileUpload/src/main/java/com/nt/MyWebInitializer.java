package com.nt;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {

	 private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringWebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		
		File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
		
		MultipartConfigElement multipartConfigElement = 
				new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
						maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
	registration.setMultipartConfig(multipartConfigElement);
	}
}
