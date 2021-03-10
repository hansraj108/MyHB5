package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	ServletContext sc = null;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sc = sce.getServletContext();
		 sc.log("Web app stopped/undeployed "+ new Date());
				 }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sc = sce.getServletContext();
		 sc.log("Web app deployed/reloaded "+ new Date());
	}

}
