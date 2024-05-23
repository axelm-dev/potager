package fr.mainguy.lebris.potager.service;

import fr.mainguy.lebris.potager.entity.Plant;
import fr.mainguy.lebris.potager.entity.Pottage;

import java.util.List;

public interface PottageService {

    public void createPottage();

    public void deletePottage();

    public void updatePottage();

    public void getPottage();

    public List<Pottage> getAllPottage();

    public void addPlantInPottage(Plant plant);

    public void updatePlantInPottage(Plant plant);

    public void removePlantInPottage(Plant plant);


    public List<Plant> getAllPlantInPottage();


    public List<Plant> getAllPlantInPottageByTypePlant(String typePlant);
}
