package fr.mainguy.lebris.potager.service;

import fr.mainguy.lebris.potager.entity.Square;

import java.util.List;

public interface SquareService {

    public void createSquare(Square square);

    public void removeSquare(Square square);

    public void updateSquare(Square square);

    public Square getSquare(Square square);

    public List<Square> getAllSquare();
}
