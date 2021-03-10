package com.hr;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;



public class Test {

	public static void main(String[] args) {
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/com/hr/ApplicationContext.xml"));
		Robot target=(Robot)factory.getBean("robot",Robot.class);
		
		System.out.println(target);
	}
}
