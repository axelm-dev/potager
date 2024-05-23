package fr.mainguy.lebris.potager.service.impl;

import fr.mainguy.lebris.potager.entity.Square;
import fr.mainguy.lebris.potager.repository.SquareRepository;
import fr.mainguy.lebris.potager.service.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquareServiceImpl implements SquareService {

    @Autowired
    SquareRepository repo;

    @Override
    public void createSquare(Square square) {
        repo.save(square);
    }

    @Override
    public void removeSquare(Square square) {
        repo.delete(square);
    }

    @Override
    public void updateSquare(Square square) {
        repo.save(square);
    }

    @Override
    public Square getSquare(Square square) {
        return repo.findById(square.getId()).orElse(null);
    }

    @Override
    public List<Square> getAllSquare() {
        return repo.findAll();
    }
}
