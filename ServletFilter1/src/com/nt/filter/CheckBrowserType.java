package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class CheckBrowserType implements Filter{

	String browser = null;
	PrintWriter pw = null;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		pw = resp.getWriter();
		resp.setContentType("text/html");
		browser = ((HttpServletRequest)req).getHeader("user-agent");
		if (browser.indexOf("chrome")== -1) {
			pw.println("Request must be given from mozilla");
			return;
		}else
		chain.doFilter(req, resp);
	}

}
