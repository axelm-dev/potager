package fr.mainguy.lebris.potager.controller;

import fr.mainguy.lebris.potager.entity.Square;
import fr.mainguy.lebris.potager.service.SquareService;
import fr.mainguy.lebris.potager.service.exception.SquareException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/square")
public class SquareController {

    @Autowired
    SquareService service;

    @PostMapping("/create")
    public void createSquare(@RequestBody Square square) throws SquareException {
        if(square == null) {
            throw new SquareException("Square cannot be null");
        }
        service.createSquare(square);
    }

    @PostMapping("/remove")
    public void removeSquare(@RequestBody Square square) throws SquareException {
        if(square == null) {
            throw new SquareException("Square cannot be null");
        }
        service.removeSquare(square);
    }

    @PostMapping("/update")
    public void updateSquare(@RequestBody Square square) throws SquareException {
        if(square == null) {
            throw new SquareException("Square cannot be null");
        }
        service.updateSquare(square);
    }

    @PostMapping("/get")
    public Square getSquare(@RequestBody Square square) throws SquareException {
        if(square == null) {
            throw new SquareException("Square cannot be null");
        }
        return service.getSquare(square);
    }

    @PostMapping("/getAll")
    public List<Square> getAllSquare() {
        return service.getAllSquare();
    }
}
