package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController extends javax.servlet.http.HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = null;
		pw = resp.getWriter();
		pw.println("<center><b> the username is : " +req.getRemoteUser()+ " </center></b>");
		pw.println("<center><b> the authtype is : " +req.getAuthType()+ " </center></b>");
	//	pw.println("<center><b> the authtype is : " +req.getUse+ " </center></b>");
		pw.close();
}

	
	
}
