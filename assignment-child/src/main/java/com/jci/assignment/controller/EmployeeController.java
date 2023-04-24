package com.jci.assignment.controller;

import com.jci.assignment.model.Company;
import com.jci.assignment.model.Employee;
import com.jci.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    //autowire the EmployeeService class
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    //creating a get mapping that retrieves the detail of a specific employee
    @GetMapping("/employee/{employeeId}")
    private Employee getEmployee(@PathVariable("employeeId") int employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }

    //creating a delete mapping that deletes a specified employee
    @DeleteMapping("/employee/{employeeId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private void deleteCompany(@PathVariable("employeeId") int employeeId)
    {
        employeeService.delete(employeeId);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/employee")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private int saveEmployee(@RequestBody Employee employee)
    {
        employeeService.saveOrUpdate(employee);
        return employee.getEmployeeId();
    }

    //creating put mapping that updates the company detail
    @PutMapping("/company")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private Employee update(@RequestBody Employee employee)
    {
        employeeService.saveOrUpdate(employee);
        return employee;
    }
}
