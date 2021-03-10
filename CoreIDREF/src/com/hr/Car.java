package com.hr;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Car {

	private String beanId;

	public Car(String beanId) {
		super();
		this.beanId = beanId;
	}
	
	public void drive() {
		int status;
		
		IEngine engine = null;
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/com/hr/ApplicationContext.xml"));
		engine=factory.getBean("beanId",IEngine.class);
		status=engine.startup();
		if(status == 1) {
			System.out.println("Engine Starts");
		}else {
			System.out.println("Engine Not Starts");
		}
		
		
	}
}
