package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CheckInputFilter implements Filter{

	public CheckInputFilter() {
		System.out.println("CheckInputFilter.CheckInputFilter()");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("CheckInputFilter.destroy()");
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CheckInputFilter.init()");
	}


	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CheckInputFilter.doFilter()");
		
		int val1 = Integer.parseInt(req.getParameter("val1"));
		int val2 = Integer.parseInt(req.getParameter("val2"));
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		if(val1<0 ||val2<0) {
			pw.println("<h4 style='color:red'> Input must be positive</h4>");
			pw.println("<a href='form.html'>Home</a>");
		} else {
			System.out.println("CheckInputFilter --> before chain.doFilter()");
			chain.doFilter(req,resp);
			System.out.println("CheckInputFilter --> after chain.doFilter()");
		}
	}

}
