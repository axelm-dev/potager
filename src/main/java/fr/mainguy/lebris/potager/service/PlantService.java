package fr.mainguy.lebris.potager.service;

import fr.mainguy.lebris.potager.entity.Plant;
import fr.mainguy.lebris.potager.entity.Pottage;

import java.util.List;

public interface PlantService {

    public void createPlant(Plant plant);

    public void removePlant(Plant plant);

    public void updatePlant(Plant plant);

    public Plant getPlant(Plant plant);

    public List<Plant> getAllPlant();

    public void addPlantInPottage(Plant plant);

    public void updatePlantInPottage(Plant plant);

    public void removePlantInPottage(Plant plant);


    public List<Plant> getAllPlantInPottage(Pottage pottage);
}
