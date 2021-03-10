package com.nt.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

	private long start,end;
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		start = System.currentTimeMillis();
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		end = System.currentTimeMillis();
		ServletContext sc = sre.getServletContext();
		sc.log(((HttpServletRequest)sre.getServletRequest()).getRequestURL()+"has taken "+(end-start) +"ms");
	}

	
	
}
