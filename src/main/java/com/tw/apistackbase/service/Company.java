package com.tw.apistackbase.service;

import java.util.ArrayList;

public class Company {

    private String companyName;
    private int employeesNumber;
    private ArrayList<Employee> employees;

    public Company() {

    }

    public Company(String companyName, int employeesNumber) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
  //      this.employees = employees;

    }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getEmployeesNumber() { return employeesNumber; }

    public ArrayList<Employee> getEmployees() { return employees; }

    public void setEmployees(ArrayList<Employee> employees) { this.employees = employees; }

}
