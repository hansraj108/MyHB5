package com.nt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {  
	  
public static void main(String[] args) {  
    ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/applicationContext.xml");  
      
 
    EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
    /*
    int status=dao.saveEmployee(new Employee(102,"Amit",35000));  
    System.out.println(status);  
    */
  /*        
    int status=dao.updateEmployee(new Employee(102,"Sonoo",15000)); 
    System.out.println(status); 
    */  
          
 //   EmployeeDao dao=(EmployeeDao)factory.getBean("edao");  
    int status=dao.update(new Employee(23,"Tarun",35000));  
    System.out.println(status);   
      
}  
  
}  