package fr.mainguy.lebris.potager.controller;

import fr.mainguy.lebris.potager.entity.Plant;
import fr.mainguy.lebris.potager.service.PlantService;
import fr.mainguy.lebris.potager.service.exception.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plant")
public class PlantController {

    @Autowired
    PlantService service;

    @PostMapping("/create")
    public void createPlant(@RequestBody Plant plant) throws PlantException {
        if(plant == null) {
            throw new PlantException("Plant cannot be null");
        }
        service.createPlant(plant);
    }

    @PostMapping("/remove")
    public void removePlant(@RequestBody Plant plant) throws PlantException {
        if(plant == null) {
            throw new PlantException("Plant cannot be null");
        }
        service.removePlant(plant);
    }

    @PostMapping("/update")
    public void updatePlant(@RequestBody Plant plant) throws PlantException {
        if(plant == null) {
            throw new PlantException("Plant cannot be null");
        }
        service.updatePlant(plant);
    }

    @GetMapping("/get")
    public Plant getPlant() throws PlantException {
        Plant plant = new Plant();
        plant.setId(1L);
        plant.setNom("Tomato");
        return service.getPlant(plant);
    }

    @GetMapping("/getAll")
    public List<Plant> getAllPlant() {
        return service.getAllPlant();
    }

}
