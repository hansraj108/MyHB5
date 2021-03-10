package com.hr;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;



public class Test {

	public static void main(String[] args) {
		BeanFactory parentFactory=new XmlBeanFactory(new FileSystemResource("src/com/hr/parentBean.xml"));
		BeanFactory childFactory=new XmlBeanFactory(new FileSystemResource("src/com/hr/childBean.xml"),parentFactory);
		
		Child child = childFactory.getBean("child",Child.class);
		System.out.println(child);
	}
}
