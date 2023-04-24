package com.jci.assignment.service;

import com.jci.assignment.model.Company;
import com.jci.assignment.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employees1 -> employees.add(employees1));
        return employees;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Employee employee)
    {
        employeeRepository.save(employee);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        employeeRepository.deleteById(id);
    }

    //updating a record
    public void update(Employee employee, int companyId)
    {
        employeeRepository.save(employee);
    }
}
