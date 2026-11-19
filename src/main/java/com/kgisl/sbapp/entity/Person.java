package com.kgisl.sbapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private String uname;
    private String email;

    public Person() {
    }

    public Person(int id, String uname, String email) {
        this.id = id;
        this.uname = uname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", uname=" + uname + ", email=" + email + "]";
    }

    
}
