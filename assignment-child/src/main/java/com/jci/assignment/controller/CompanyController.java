package com.jci.assignment.controller;

import com.jci.assignment.model.Company;
import com.jci.assignment.service.BuildingService;
import com.jci.assignment.service.CompanyService;
import com.jci.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    //autowire the companyService class
    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    private List<Company> getAllCompanies()
    {
        return companyService.getAllCompanies();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/company/{companyId}")
    private Company getCompany(@PathVariable("companyId") int companyId)
    {
        return companyService.getCompanyById(companyId);
    }

    //creating a delete mapping that deletes a specified company
    @DeleteMapping("/company/{companyId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private void deleteCompany(@PathVariable("companyId") int companyId)
    {
        companyService.delete(companyId);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/company")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private int saveCompany(@RequestBody Company company)
    {
        companyService.saveOrUpdate(company);
        return company.getCompanyId();
    }

    //creating put mapping that updates the company detail
    @PutMapping("/company")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private Company update(@RequestBody Company company)
    {
        companyService.saveOrUpdate(company);
        return company;
    }
}
