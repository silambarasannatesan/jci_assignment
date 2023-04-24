package com.jci.assignment.service;

import com.jci.assignment.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.BuildingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    public List<Building> getAllBuildings()
    {
        List<Building> buildings = new ArrayList<Building>();
        buildingRepository.findAll().forEach(building -> buildings.add(building));
        return buildings;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Building getBuildingById(int id)
    {
        return buildingRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Building building)
    {
        buildingRepository.save(building);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        buildingRepository.deleteById(id);
    }

    //updating a record
    public void update(Building building, int buildingId)
    {
        buildingRepository.save(building);
    }

}
