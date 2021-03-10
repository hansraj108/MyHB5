package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet22 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<b>First form data </b><br>");
		pw.println("<br> Name is : "+req.getParameter("hname"));
		pw.println("<br> Age is : "+req.getParameter("hage"));
		pw.println("<br> Maritial status is : "+req.getParameter("hms")+"<br>");
		pw.println("<b>Second form data </b><br>");
		pw.println("<br> St1 : "+req.getParameter("st1"));
		pw.println("<br> St2 : "+req.getParameter("st2"));
		
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
