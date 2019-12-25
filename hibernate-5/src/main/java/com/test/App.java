package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Student std = new Student();
        std.setName("tttt");
        std.setId(206);


        Laptop laptop1 = new Laptop();
        laptop1.setLid(17);
        laptop1.setBrand("pppp");
        laptop1.setStudent(std);

        Laptop laptop2 = new Laptop();
        laptop2.setLid(18);
        laptop2.setBrand("pppp");
        laptop2.setStudent(std);
        List<Laptop> laptopList = new ArrayList();
        laptopList.add(laptop1);
        laptopList.add(laptop2);

        std.setLaptop(laptopList);
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Laptop.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();
        se.save(laptop1);
        se.save(laptop2);
        se.save(std);

        se.getTransaction().commit();
        System.out.println("Done");
    }
}