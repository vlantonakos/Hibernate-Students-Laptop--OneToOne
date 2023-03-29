package com.vlanto.DemoHibe;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	
    	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
        Student s = new Student();
        s.setName("Vlanto");
        s.setRollno(1);
        s.setMarks(50);
        s.setLaptop(laptop);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(laptop);
        session.save(s);
        
        tx.commit();
        
    }
}
