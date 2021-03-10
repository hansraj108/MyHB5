package com.hr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;

import com.hr.view.PdfView;
import com.hr.view.XlsView;
import com.hr.view.XlsxView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hr")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
				.defaultContentType(MediaType.TEXT_HTML)
				.ignoreAcceptHeader(true);
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/ui/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("/ui/css/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("WEB-INF/jsp", ".jsp").viewClass(JstlView.class);
		registry.enableContentNegotiation(
				new XlsView(),
				new XlsxView(),
				new PdfView()
				);
	}

}
