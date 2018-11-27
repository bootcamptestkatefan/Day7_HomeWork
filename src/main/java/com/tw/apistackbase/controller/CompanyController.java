package com.tw.apistackbase.controller;

import com.tw.apistackbase.service.Company;
import com.tw.apistackbase.service.CompanySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanySvc companyService;

    @Autowired
    public CompanyController(CompanySvc employeeService) {

        this.companyService = companyService;
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Company>> getAll() {

        List<Company> companies = companyService.getAll();
        return ResponseEntity.ok(companies);
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Integer> create(@RequestBody Company company) {

        int id = companyService.create(company);
        return ResponseEntity.ok(id);
    }

    @PutMapping(path = "/{companyId}", consumes = {"application/json"})
    public ResponseEntity update(@PathVariable int companyId, @RequestBody Company company) {

        boolean isUpdated = companyService.update(companyId, company);
        return isUpdated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity delete(@PathVariable int companyId) {

        boolean isDeleted = companyService.delete(companyId);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
