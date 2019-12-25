package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Student std = new Student();
        std.setAddress("Bangalore");
        std.setName("Kiran");
        std.setId(101);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        Transaction transaction = se.beginTransaction();
        se.save(std);
        transaction.commit();
    }
}
