package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet33 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String city = req.getParameter("city");
		String salary = req.getParameter("salary");
		
		HttpSession ses = req.getSession(false);
		String name = (String) ses.getAttribute("name");
		String addr = (String) ses.getAttribute("addr");
		String  age = (String) ses.getAttribute("age");
		String  exp = (String) ses.getAttribute("exp");
		String skills = (String) ses.getAttribute("skills");
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("Registration Details .....<br>");
		
		pw.println("Name is: "+name+"<br>");
		pw.println("Addr is: "+addr+"<br>");
		pw.println("Age is: "+age+"<br>");
		pw.println("Exp is: "+exp+"<br>");
		pw.println("Skills are: "+skills+"<br>");
		pw.println("City is: "+city+"<br>");
		pw.println("Salary is: "+salary+"<br>");
		pw.println(ses.getId());
		pw.println("<a href='details.html'>Home</a>");
		
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
