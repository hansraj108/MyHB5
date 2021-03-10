package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		Cookie[] cks = req.getCookies();
		pw.println("<b>First form data </b><br>");
		if(cks != null) {
		String name = cks[0].getValue();
		String age = cks[1].getValue();
		String ms = cks[2].getValue();
		pw.println("<br> Name is : "+name);
		pw.println("<br> Age is : "+age);
		pw.println("<br> Maritial status is : "+ms);
		}
		/*
		 * for(Cookie ck:cks) {
		 * pw.println("<br> <b>"+ck.getName()+"</b> "+ck.getValue()); }
		 */
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
