package com.jci.assignment.service;

import com.jci.assignment.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies()
    {
        List<Company> companies = new ArrayList<Company>();
        companyRepository.findAll().forEach(companies1 -> companies.add(companies1));
        return companies;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Company getCompanyById(int id)
    {
        return companyRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Company company)
    {
        companyRepository.save(company);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        companyRepository.deleteById(id);
    }

    //updating a record
    public void update(Company company, int companyId)
    {
        companyRepository.save(company);
    }
}
