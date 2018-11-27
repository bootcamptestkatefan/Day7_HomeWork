package com.tw.apistackbase.service;

public class Company {


    public Company() {

    }

    public Company(String name, int age, String gender, int salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    private String name;
    private int age;
    private int id;
    private String gender;
    private int salary;

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }
}
