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
        se.save(student);
        //Student s1 = (Student) se.get(Student.class, 1001);//eager loading
//        System.out.println(s1);
//        Student s1 = (Student) se.load(Student.class, 1001);//lazy loading
//        System.out.println(s1);

//        Student s1 = (Student) se.get(Student.class, 10);//Null returns in case of no Object Found
//        System.out.println(s1);
        Student s1 = (Student) se.load(Student.class, 10);//exception returns in case of no Object Found
        System.out.println(s1);
    }
}