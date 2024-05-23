package fr.mainguy.lebris.potager.service;

import fr.mainguy.lebris.potager.entity.Square;

import java.util.List;

public interface SquareService {

    public void createSquare();

    public void removeSquare();

    public void updateSquare();

    public void getSquare();

    public List<Square> getAllSquare();
}
