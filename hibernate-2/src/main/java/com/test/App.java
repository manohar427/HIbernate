package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Student std = null;

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        Transaction transaction = se.beginTransaction();
        Student student = (Student) se.get(Student.class, 104);//if data not found,null will get
        //Student student=  (Student) se.load(Student.class,1004);//Exception will throw if data not found
        System.out.println(student);
        transaction.commit();
        System.out.println("Done");
    }
}