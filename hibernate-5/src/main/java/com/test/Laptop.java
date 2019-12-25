package com.test;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    private int lid;
    private String brand;
    @ManyToOne
    private Student student;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
