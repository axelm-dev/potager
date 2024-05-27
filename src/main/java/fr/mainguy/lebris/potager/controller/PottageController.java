package fr.mainguy.lebris.potager.controller;

import fr.mainguy.lebris.potager.entity.Pottage;
import fr.mainguy.lebris.potager.service.PottageService;
import fr.mainguy.lebris.potager.service.exception.PottageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pottage")
public class PottageController {

    @Autowired
    PottageService service;

    @PostMapping("/create")
    public void createPottage(@RequestBody Pottage pottage) throws PottageException {
        if(pottage == null) {
            throw new PottageException("Pottage cannot be null");
        }
        System.out.println("Pottage created (controller) " + pottage.toString());
        service.createPottage(pottage);
    }

    @PostMapping("/remove")
    public void removePottage(@RequestBody Pottage pottage) throws PottageException {
        if(pottage == null) {
            throw new PottageException("Pottage cannot be null");
        }
        System.out.println("Pottage removed (controller) " + pottage.toString());
        service.deletePottage(pottage);
    }

    @PostMapping("/update")
    public void updatePottage(@RequestBody Pottage pottage) throws PottageException {
        if(pottage == null) {
            throw new PottageException("Pottage cannot be null");
        }
        System.out.println("Pottage updated (controller) " + pottage.toString());
        service.updatePottage(pottage);
    }

    @PostMapping("/get")
    public Pottage getPottage(@RequestBody Pottage pottage) throws PottageException {
        if(pottage == null) {
            throw new PottageException("Pottage cannot be null");
        }
        return service.getPottage(pottage);
    }

    @PostMapping("/getAll")
    public List<Pottage> getAllPottage() {
        return service.getAllPottage();
    }
}
