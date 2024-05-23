package fr.mainguy.lebris.potager.service.impl;

import fr.mainguy.lebris.potager.entity.Plant;
import fr.mainguy.lebris.potager.entity.Pottage;
import fr.mainguy.lebris.potager.repository.PlantRepository;
import fr.mainguy.lebris.potager.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    PlantRepository repo;

    @Override
    public void createPlant(Plant plant) {

    }

    @Override
    public void removePlant(Plant plant) {

    }

    @Override
    public void updatePlant(Plant plant) {

    }

    @Override
    public Plant getPlant(Plant plant) {
        return repo.findById(plant.getId()).orElse(null);
    }

    @Override
    public List<Plant> getAllPlant() {

        return (List<Plant>) repo.findAll();
    }

    @Override
    public void addPlantInPottage(Plant plant) {

    }

    @Override
    public void updatePlantInPottage(Plant plant) {

    }

    @Override
    public void removePlantInPottage(Plant plant) {

    }

    @Override
    public List<Plant> getAllPlantInPottage(Pottage pottage) {
        return List.of();
    }
}
