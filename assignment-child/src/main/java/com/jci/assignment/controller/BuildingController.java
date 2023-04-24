package com.jci.assignment.controller;

import com.jci.assignment.model.Building;
import com.jci.assignment.model.Company;
import com.jci.assignment.service.BuildingService;
import com.jci.assignment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingController {

    //autowire the companyService class
    @Autowired
    BuildingService buildingService;

    @GetMapping("/buildings")
    private List<Building> getAllBuildings()
    {
        return buildingService.getAllBuildings();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/building/{buildingId}")
    private Building getBuilding(@PathVariable("buildingId") int buildingId)
    {
        return buildingService.getBuildingById(buildingId);
    }

    //creating a delete mapping that deletes a specified company
    @DeleteMapping("/building/{buildingId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private void deleteCompany(@PathVariable("buildingId") int companyId)
    {
        buildingService.delete(companyId);
    }

    //creating post mapping that post the book detaicompanyServicel in the database
    @PostMapping("/building")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private int saveBuilding(@RequestBody Building building)
    {
        buildingService.saveOrUpdate(building);
        return building.getBuildingId();
    }

    //creating put mapping that updates the company detail
    @PutMapping("/company")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private Building update(@RequestBody Building building)
    {
        buildingService.saveOrUpdate(building);
        return building;
    }
}
