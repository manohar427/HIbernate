package com.test;

import javax.persistence.*;

@Entity
@Table(name = "Student_Demo")
public class Student {
    @Id
    private int id;
    //@Transient -- Not to store this column in to DB
    private String name;
    @Column(name = "address_xxx")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}