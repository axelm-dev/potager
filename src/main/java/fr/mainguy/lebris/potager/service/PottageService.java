package fr.mainguy.lebris.potager.service;

import fr.mainguy.lebris.potager.entity.Plant;

import java.util.List;

public interface PottageService {

    public void addPlantInPottage(Plant plant);


    public void removePlantInPottage(Plant plant);


    public List<Plant> getAllPlantInPottage();


    public List<Plant> getAllPlantInPottageByTypePlant(String typePlant);
}
