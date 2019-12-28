package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);

        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();
        Student student1 = (Student) se.get(Student.class, 206);
        System.out.println(student1);
        se.getTransaction().commit();

        Session se1 = sf.openSession();
        se1.beginTransaction();
        Student student2 = (Student) se1.get(Student.class, 206);
        System.out.println(student2);
        se1.getTransaction().commit();
    }
}