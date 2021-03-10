package com.hr.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      
      Robot student = (Robot) context.getBean("Robot", Robot.class);
      System.out.println(student);
      
   }
}