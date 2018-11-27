package com.tw.apistackbase.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanySvc {


    private List<Company> companies;
    private int idIndex = 0;

    public CompanySvc() {
        this.companies = new ArrayList<>();
        this.companies.add(new Company("alibaba1", 20, "male", 6000));
        this.companies.add(new Company("tengxun2", 19, "female", 7000));
    }

    public List<Company> getAll() {

        return this.companies;
    }

    public int create(Company company) {
        this.idIndex = this.idIndex + 1;
        company.setId(idIndex);
        this.companies.add(company);
        return idIndex;
    }

    public boolean update(int companyId, Company updatedCompany) {
        boolean isSuccess = false;
        Optional<Company> optionalCompany = findCompanyById(companyId);
        if (optionalCompany.isPresent()) {
            this.companies.remove(optionalCompany.get());
            updatedCompany.setId(companyId);
            this.companies.add(updatedCompany);
            isSuccess = true;
        }
        return isSuccess;
    }

    private Optional<Company> findCompanyById(int companyId) {
        return this.companies.stream()
                .filter(companyElement -> companyElement.getId() == companyId)
                .findFirst();
    }

    public boolean delete(int companyId) {
        boolean isSuccess = false;
        Optional<Company> company = findCompanyById(companyId);
        if (company.isPresent()) {
            this.companies.remove(company.get());
            isSuccess = true;
        }
        return isSuccess;
    }
}
