package com.tw.apistackbase.controller;

import com.tw.apistackbase.service.Employee;
import com.tw.apistackbase.service.EmployeeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeSvc employeeSvc;

    @Autowired
    public EmployeeController(EmployeeSvc employeeSvc) {

        this.employeeSvc = employeeSvc;
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll() {

        List<Employee> employees = employeeSvc.getAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Integer> create(@RequestBody Employee employee) {

        int id = employeeSvc.create(employee);
        return ResponseEntity.ok(id);
    }

    @PutMapping(path = "/{employeeId}", consumes = {"application/json"})
    public ResponseEntity update(@PathVariable int employeeId, @RequestBody Employee employee) {

        boolean isUpdated = employeeSvc.update(employeeId, employee);
        return isUpdated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity delete(@PathVariable int employeeId) {

        boolean isDeleted = employeeSvc.delete(employeeId);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
