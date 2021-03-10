package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet11 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("pname");
		String age = req.getParameter("page");
		String mstatus = req.getParameter("ms");
		
		if(mstatus == null)
			mstatus="single";
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		if(mstatus.equals("married")) {
			pw.println("<form action='xyz' method='post'>");
			pw.println("<b>Spouse Name: </b><input type='text' name='st1'><br>");
			pw.println("<b>Children No: </b><input type='text' name='st2'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
			}else {
				pw.println("<form action='xyz' method='post'>");
				pw.println("<b> When do u want to marry: </b><input type='text' name='st1'><br>");
				pw.println("<b> Why do u want to marry: </b><input type='text' name='st2'><br>");
				pw.println("<input type='submit' value='submit'>");
				pw.println("</form>");
			}
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
