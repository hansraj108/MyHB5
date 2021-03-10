package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SumServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer val1 = Integer.parseInt(req.getParameter("val1"));
		Integer val2 = Integer.parseInt(req.getParameter("val2"));
		
		int sum = val1 + val2;
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("<h1>Result is: "+sum+"</h1>");
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
