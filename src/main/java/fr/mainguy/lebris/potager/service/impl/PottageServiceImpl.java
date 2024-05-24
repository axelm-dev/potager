package fr.mainguy.lebris.potager.service.impl;

import fr.mainguy.lebris.potager.entity.Plant;
import fr.mainguy.lebris.potager.entity.Pottage;
import fr.mainguy.lebris.potager.repository.PottageRepository;
import fr.mainguy.lebris.potager.service.PottageService;
import fr.mainguy.lebris.potager.service.exception.PottageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PottageServiceImpl implements PottageService {

    @Autowired
    PottageRepository repo;

    @Override
    public void createPottage(Pottage pottage) throws PottageException {
        if(pottage == null) {
            throw new PottageException("Pottage cannot be null");
        }
        repo.save(pottage);
    }

    @Override
    public void deletePottage(Pottage pottage) {
        repo.delete(pottage);
    }

    @Override
    public void updatePottage(Pottage pottage) throws PottageException {
            repo.save(pottage);
    }

    @Override
    public Pottage getPottage(Pottage pottage) {
        return repo.findById(pottage.getId()).orElse(null);
    }

    @Override
    public List<Pottage> getAllPottage() {
        return (List<Pottage>) repo.findAll();
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

    @Override
    public List<Plant> getAllPlantInPottageByTypePlant(String typePlant) {
        return List.of();
    }
}
