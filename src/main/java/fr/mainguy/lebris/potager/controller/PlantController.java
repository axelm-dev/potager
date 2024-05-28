package fr.mainguy.lebris.potager.controller;

import fr.mainguy.lebris.potager.entity.Plant;
import fr.mainguy.lebris.potager.service.PlantService;
import fr.mainguy.lebris.potager.service.exception.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plant")
public class PlantController {

    @Autowired
    PlantService service;

    @PostMapping("/create")
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) throws PlantException {
        if(plant == null) {
            throw new PlantException("Plant cannot be null");
        }
        service.createPlant(plant);
        return ResponseEntity.ok(plant);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Plant> removePlant(@RequestBody Plant plant) throws PlantException {
        if(getPlant(plant.getId()).equals(HttpStatus.NOT_FOUND)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.removePlant(plant);
        return ResponseEntity.ok(plant);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) throws PlantException {
        if(plant == null) {
            throw new PlantException("Plant cannot be null");
        }
        service.updatePlant(plant);
        return ResponseEntity.ok(plant);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable Long id) throws PlantException {
        if (id == null) {
            throw new PlantException("Plant Id cannot be null");
        }
        if(service.getPlant(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(service.getPlant(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Plant>> getAllPlant() {
        return ResponseEntity.ok(service.getAllPlant());
    }

}
