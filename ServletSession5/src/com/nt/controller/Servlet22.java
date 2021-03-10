package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet22 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String exp = req.getParameter("exp");
		String skills = req.getParameter("skill_set");
		
		HttpSession ses = req.getSession(false);
		ses.setAttribute("exp", exp);
		ses.setAttribute("skills", skills);
		
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("<form action="+resp.encodeUrl("third")+" method='post'>");
		pw.println("Expected City & Salary .....");
		pw.println("<b>Expected City: </b><input type='text' name='city'><br>");
		pw.println("<b>Expected Salary: </b><input type='text' name='salary'><br>");
	//	pw.println(resp.encodeRedirectUrl("second"));
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	

}
