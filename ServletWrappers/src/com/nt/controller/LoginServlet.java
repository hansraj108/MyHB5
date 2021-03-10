package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		if(uname.equals("hans@gmail.com") && pwd.equals("rani")) 
			pw.println("<h1 style='color:green'> Valid Credentials</h1>");
		else
			pw.println("<h1 style='color:red'> InValid Credentials</h1>");
		
		pw.println("<a href='form.html'>Home</a>");
		
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
