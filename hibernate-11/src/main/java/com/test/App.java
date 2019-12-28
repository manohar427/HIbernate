package com.test;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.ResultTransformer;

import java.awt.*;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);

        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();
        Student student = new Student();
        student.setId(1001);
        student.setName("ABC");
        //  se.save(student);
        student.setName("DEF3");
        //se.delete(student);//removed from DB

        se.merge(student);//Adding in to Session
        Student s1 = (Student) se.get(Student.class, 1001);
        System.out.println(s1);
        //se.getTransaction().commit();
        se.evict(student);//Removes from Session
    }
}