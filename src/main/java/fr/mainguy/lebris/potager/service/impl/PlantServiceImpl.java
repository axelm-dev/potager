package fr.mainguy.lebris.potager.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mainguy.lebris.potager.entity.Plant;
import fr.mainguy.lebris.potager.entity.Pottage;
import fr.mainguy.lebris.potager.repository.PlantRepository;
import fr.mainguy.lebris.potager.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    private static final String PLANTS_JSON_FILE = "classpath:static/plantes.json";

    @Autowired
    private ResourceLoader resourceLoader;

    private void init() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Plant>> typeReference = new TypeReference<List<Plant>>() {};

        Resource resource = resourceLoader.getResource(PLANTS_JSON_FILE);
        try (InputStream inputStream = resource.getInputStream()) {
            List<Plant> plants = mapper.readValue(inputStream, typeReference);

            if (repo.count() == 0) {
                repo.saveAll(plants);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read plants.json file", e);
        }
    }

    @Override
    public List<Plant> getAllPlant() {
        if (repo.count() == 0) {
            init();
        }
        return (List<Plant>) repo.findAll();
    }

    @Autowired
    PlantRepository repo;

    @Override
    public void createPlant(Plant plant) {
        repo.save(plant);
    }

    @Override
    public void removePlant(Plant plant) {
        repo.delete(plant);
    }

    @Override
    public void updatePlant(Plant plant) {
        repo.save(plant);
    }

    @Override
    public Plant getPlant(Long id) {
        return repo.findById(id).orElse(null);
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
