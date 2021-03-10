package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class RequestBrowserTypeFilter implements Filter{

	int counter=0;
	ServletContext sc = null;
	
	@Override
	public void destroy() {
		sc=null;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		sc = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		long start=0, end=0;
		PrintWriter pw = null;
		
		
		pw = resp.getWriter();
		resp.setContentType("text/html");
		start = System.currentTimeMillis();
		chain.doFilter(req, resp);
		end = System.currentTimeMillis();
		
		System.out.println(((HttpServletRequest)req).getRequestURL()+" has taken "+ (end-start) + "ms");
		sc.log(((HttpServletRequest)req).getRequestURL()+" has taken "+ (end-start) + "ms");
	}

}
