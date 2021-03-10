package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet11 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("pname");
		String addr = req.getParameter("padd");
		String age = req.getParameter("page");
		
		HttpSession ses = req.getSession();
		ses.setAttribute("name", name);
		ses.setAttribute("addr", addr);
		ses.setAttribute("age", age);
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		


		pw.println("<form action='second' method='post'>");
		pw.println("<b>Experience: </b><input type='text' name='exp'><br>");
		pw.println("<b><select name =skill_set>");
		pw.println("<option value=Java>Java/j2ee</option>");
		pw.println("<option value=.Net>.Net</option>");
		pw.println("<option value=Oracle>Oracle</option>");
		pw.println("<input type='submit' value='continue'>");
		pw.println("</form>");
		
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
