package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        Student std = new Student();
//        std.setName("tttt");
//        std.setId(206);
//
//        Laptop laptop1 = new Laptop();
//        laptop1.setLid(17);
//        laptop1.setBrand("pppp");
//
//        List<Laptop> laptopList = new ArrayList();
//        laptopList.add(laptop1);
//
//        std.setLaptop(laptopList);

//        List<Student> studentList = new ArrayList();
//        studentList.add(std);
//
        //      laptop1.setStudent(std);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Laptop.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();
        System.out.println("Before getting data..");
//        se.save(laptop1);
//        se.save(std);
        Student student = (Student) se.get(Student.class, 206);
        System.out.println(student.getName());
        System.out.println(student.getId());
      //  System.out.println(student.getLaptop());//It will call Laptop table
        //By default Lazy loading
        se.getTransaction().commit();
        System.out.println("Done");
    }
}