package fr.mainguy.lebris.potager.service;

import fr.mainguy.lebris.potager.entity.Plant;
import fr.mainguy.lebris.potager.entity.Pottage;
import fr.mainguy.lebris.potager.service.exception.PottageException;

import java.util.List;

public interface PottageService {

    public void createPottage(Pottage pottage) throws PottageException;

    public void deletePottage(Pottage pottage);

    public void updatePottage(Pottage pottage);

    public Pottage getPottage(Pottage pottage);

    public List<Pottage> getAllPottage();

    public void addPlantInPottage(Plant plant);

    public void updatePlantInPottage(Plant plant);

    public void removePlantInPottage(Plant plant);


    public List<Plant> getAllPlantInPottage(Pottage pottage);


    public List<Plant> getAllPlantInPottageByTypePlant(String typePlant);
}
