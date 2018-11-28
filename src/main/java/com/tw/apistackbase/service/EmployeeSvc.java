package com.tw.apistackbase.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSvc {


    private List<Employee> employees;
    private int idIndex = 0;

    public EmployeeSvc() {
        this.employees = new ArrayList<>();
        this.employees.add(new Employee("alibaba1", 20, "male", 6000));
        this.employees.add(new Employee("tengxun2", 19, "female", 7000));
        this.employees.add(new Employee("alibaba3", 19, "male", 8000));
    }

    public List<Employee> getAll() {

        return this.employees;
    }

    public int create(Employee employee) {
        this.idIndex = this.idIndex + 1;
           employee.setId(idIndex);
        this.employees.add(employee);
        return idIndex;
    }

    public boolean update(int employeeId, Employee updatedEmployee) {
        boolean isSuccess = false;
        Optional<Employee> optionalEmployee = findEmployeeById(employeeId);
        if (optionalEmployee.isPresent()) {
            this.employees.remove(optionalEmployee.get());
             updatedEmployee.setId(employeeId);
            this.employees.add(updatedEmployee);
            isSuccess = true;
        }
        return isSuccess;
    }

    private Optional<Employee> findEmployeeById(int employeeId) {
        return this.employees.stream()
                        .filter(employeeElement -> employeeElement.getId() == employeeId)
                .findFirst();
    }

    public boolean delete(int employeeId) {
        boolean isSuccess = false;
        Optional<Employee> employee = findEmployeeById(employeeId);
        if (employee.isPresent()) {
            this.employees.remove(employee.get());
            isSuccess = true;
        }
        return isSuccess;
    }
}
