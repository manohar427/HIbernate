package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Student std = new Student();
        std.setName("tttt");
        std.setId(206);


        Laptop laptop = new Laptop();
        laptop.setLid(17);
        laptop.setBrand("pppp");

        std.setLaptop(laptop);
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Laptop.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();
        se.save(laptop);
        se.save(std);

        se.getTransaction().commit();
        System.out.println("Done");
    }
}