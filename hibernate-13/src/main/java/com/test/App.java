package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("OOO");
        student.setId(452);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("abc");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        // Student student = entityManager.find(Student.class, 206);
        entityManager.persist(student);
        System.out.println(student);
        entityManager.getTransaction().commit();
    }
}