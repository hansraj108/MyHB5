package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class DoublePostingPreventionFilter implements Filter{

//	@SuppressWarnings("null")
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpSession ses= null;
		HttpServletRequest hreq = null;
		int serverToken = 0;
		int clientToken = 0;
		
		hreq = (HttpServletRequest) req;
		ses = hreq.getSession();
		//for 1st req
		if(hreq.getMethod().equals("GET")) {
			
			ses.setAttribute("stoken", new Random().nextInt(10000));
			chain.doFilter(req, resp);
		}else {
			serverToken = (Integer) ses.getAttribute("stoken");
			clientToken = Integer.parseInt(req.getParameter("ctoken"));
			
		}
		if(serverToken == clientToken) {
			ses.setAttribute("stoken", new Random().nextInt(10000));
			chain.doFilter(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/dbl_post_err.jsp");
			rd.forward(req, resp);
		}
		
		
		
	}

}
