package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CheckInputIntegerFilter implements Filter{

	public CheckInputIntegerFilter() {
		System.out.println("CheckInputIntegerFilter.CheckInputIntegerFilter()");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("CheckInputIntegerFilter.destroy()");
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CheckInputIntegerFilter.init()");
	}


	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CheckInputIntegerFilter.doFilter()");
		
		String val1 = req.getParameter("val1");
		String val2 = req.getParameter("val2");
		Integer val3;
		Integer val4;
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		if(isNumber(val1) || isNumber(val2)) {
			pw.println("<h4 style='color:red'> Input must be number</h4>");
			pw.println("<a href='form.html'>Home</a>");
		} else {
			System.out.println("CheckInputIntegerFilter --> before chain.doFilter()");
			chain.doFilter(req,resp);
			System.out.println("CheckInputIntegerFilter --> after chain.doFilter()");
		}
	}
		static boolean isNumber(String s)
	    {
	        for (int i = 0; i < s.length(); i++)
	            if (Character.isDigit(s.charAt(i)) == false)
	        return false;
	        
	        return true;
	        
	}

}
