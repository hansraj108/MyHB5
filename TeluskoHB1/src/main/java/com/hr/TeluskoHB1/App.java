package com.hr.TeluskoHB1;



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
       
    	AlienName an = new AlienName();
    	an.setfName("hans");
    	an.setlName("tan");
    	an.setsName("del");
    	
    	Alien a = new Alien();
    	a.setId(Integer.parseInt("105"));
    	a.setName(an);
    	a.setColor("PINK");
    	
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	SessionFactory sf = cfg.buildSessionFactory(sr);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	
    //	session.save(a);
   	a = (Alien) session.get(Alien.class, 105);
    	tx.commit();
    	System.out.println(a);
    }
}
