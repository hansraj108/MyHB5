package com.hans.capp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import com.hans.capp.view.PdfView;
import com.hans.capp.view.XlsView;
import com.hans.capp.view.XlsxView;

@Configuration
@EnableWebMvc
@ComponentScan (basePackages = {"com.hans"})
public class SpringWebConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
				.defaultContentType(MediaType.TEXT_HTML)
				.ignoreAcceptHeader(true);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp").viewClass(JstlView.class);
		registry.enableContentNegotiation(
				new XlsView(),
				new XlsxView(),
				new PdfView(),
				new MappingJackson2XmlView(),
				new MappingJackson2JsonView()
				);
	}
	
	/*
	 * @Bean public MultipartResolver multipartResolver() {
	 * StandardServletMultipartResolver resolver = new
	 * StandardServletMultipartResolver(); return resolver; }
	 */
	
	
	  @Bean 
	  public CommonsMultipartResolver createMultipartResolver() {
	  CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	  resolver.setDefaultEncoding("utf-8"); 
	  resolver.setMaxUploadSize(10485760);
	  resolver.setMaxUploadSizePerFile(1048576); 
	  return resolver; 
	  }
	 

}