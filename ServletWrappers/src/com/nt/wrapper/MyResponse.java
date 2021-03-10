package com.nt.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper{

	private HttpServletResponse resp;
	private CharArrayWriter writer;
	public MyResponse(HttpServletResponse response) {
		super(response);
		this.resp = response;
		writer = new CharArrayWriter();
	}
	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter pw = new PrintWriter(writer);
		return pw;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return writer.toString();
	}

	
}
