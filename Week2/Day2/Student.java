package com.example;

public class Student {

    private String name;

    public Student() {
        System.out.println("Student object created");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}