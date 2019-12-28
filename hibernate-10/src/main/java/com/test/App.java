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
        //Multiple Results
//        Query query = se.createQuery("from Student where id=207");
//        List<Student> list = query.list();
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //Single Unique result
//        Query query =  se.createQuery("from Student where id=207");
//        Student  student = (Student) query.uniqueResult();
//        System.out.println(student);
//        se.getTransaction().commit();

        //Muliple Columns
//        Query query = se.createQuery("select id,name from Student where id=207");
//        Object[] list = (Object[]) query.uniqueResult();
//        for (Object student : list) {
//            System.out.println(student);
//        }
//        se.getTransaction().commit();

        //Multi Results and multi columns
//        Query query = se.createQuery("select id,name from Student");
//        List<Object[]> list = query.list();
//        for (Object[] student : list) {
//            System.out.println(student[0] + ":" + student[1]);
//        }
//        se.getTransaction().commit();

        //Aggregate Function
//        Query query = se.createQuery("select sum(id) from Student");
//        Long sum = (Long) query.uniqueResult();
//        System.out.println("SUM:" + sum);
//        se.getTransaction().commit();

        //Prepared Statement
//        Query query = se.createQuery("select sum(id) from Student where id = :b");
//        query.setInteger("b", 206);
//        Long sum = (Long) query.uniqueResult();
//        System.out.println("SUM:" + sum);
//        se.getTransaction().commit();


//        //SQL Query/Native Query ,all columns
//        SQLQuery sqlQuery = se.createSQLQuery("select * from Student");
//        sqlQuery.addEntity(Student.class);
//        List<Student> list = sqlQuery.list();
//        for (Student student : list
//        ) {
//            System.out.println(student);
//        }
//        se.getTransaction().commit();

        //SQL Query/Native Query ,selected columns
        SQLQuery sqlQuery = se.createSQLQuery("select id,name from Student");
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Object> list = sqlQuery.list();
        for (Object student : list
        ) {
            Map map = (Map) student;
            System.out.println(map.get("name") + ":" + map.get("id"));
        }
        se.getTransaction().commit();
    }
}