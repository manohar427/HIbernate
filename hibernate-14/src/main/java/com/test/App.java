package com.test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();

        Student student = new Student();
        student.setName("OOO");
        student.setId(452);

        se.save(student);
//Criteria criteria = se.createCriteria(Student.class);
        Criteria criteria = se.createCriteria(Student.class);

        //  criteria.addOrder(Order.asc("name"));
        // criteria.add(Expression.eq("id", 200));
//        criteria.add(Restrictions.ne("id",502));
        List<Student> studentList = criteria.list();
        criteria.setMaxResults(10);
        criteria.setFirstResult(20);
        System.out.println(studentList);
        se.getTransaction().commit();
    }
}