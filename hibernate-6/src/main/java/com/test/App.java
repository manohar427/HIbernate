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

        List<Laptop> laptopList = new ArrayList();
        laptopList.add(laptop1);

        std.setLaptop(laptopList);

        List<Student> studentList = new ArrayList();
        studentList.add(std);

        laptop1.setStudent(studentList);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Laptop.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();
        se.save(laptop1);
        se.save(std);

        se.getTransaction().commit();
        System.out.println("Done");
    }
}