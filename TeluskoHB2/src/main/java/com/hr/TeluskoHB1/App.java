package com.hr.TeluskoHB1;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Laptop l = new Laptop();
    	l.setlId(407);
    	l.setlName("HP");
       
		/*
		 * Laptop l1 = new Laptop(); l1.setlId(404); l1.setlName("HP");
		 * 
		 * Laptop l2 = new Laptop(); l2.setlId(404); l2.setlName("HP");
		 */
    	
    //	List<Laptop> ll = new ArrayList<>();
    	Student s = new Student();
    	s.setsId(107);
    	s.setsName("hans");
    	s.setMarks("50");
    	s.getLaptop().add(l);
    	
    	
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	SessionFactory sf = cfg.buildSessionFactory(sr);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	session.save(l);
    	session.save(s);
  // 	a = (Alien) session.get(Alien.class, 105);
    	tx.commit();
    	System.out.println(s);
    	System.out.println(l);
    }
}
