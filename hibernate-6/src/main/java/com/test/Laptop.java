package com.test;

import javax.persistence.*;
import java.util.List;

@Entity
public class Laptop {
    @Id
    private int lid;
    private String brand;
    @ManyToMany
    private List<Student> student;

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

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", student=" + student +
                '}';
    }
}
