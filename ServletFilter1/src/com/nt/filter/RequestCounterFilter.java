package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class RequestCounterFilter implements Filter{

	int counter=0;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		counter++;
		
		ServletContext sc = req.getServletContext();
		sc.setAttribute("ReqCount", counter);
		sc.log("counter "+counter);
		chain.doFilter(req, resp);
	}

}
