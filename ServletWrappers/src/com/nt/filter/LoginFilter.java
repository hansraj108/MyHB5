package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.MyRequest;
import com.nt.wrapper.MyResponse;

public class LoginFilter implements Filter{

	public LoginFilter() {
		System.out.println("LoginFilter.LoginFilter()");
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
		MyRequest myReq = null;
		MyResponse myResp = null;
		String output = null;
		
		PrintWriter pw = null;
		
		myReq = new MyRequest((HttpServletRequest) req);
		myResp = new MyResponse((HttpServletResponse) resp);
		
		chain.doFilter(myReq, myResp);
		output = myResp.toString().toUpperCase();
		output = output + "Nvs";
		pw = resp.getWriter();
		pw.println(output);
		
	}

}
