package com.test;

import com.sun.jndi.cosnaming.IiopUrl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Student std = new Student();
        std.setName("Kiran");
        std.setId(105);


        Address address = new Address();
        address.setCity("up");
        address.setState("Up");

        std.setAddress(address);
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        Transaction transaction = se.beginTransaction();
         se.save(std);//if data not found,null will get

        transaction.commit();
        System.out.println("Done");
    }
}