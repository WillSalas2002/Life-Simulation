package com.ilkhamjumatov.simulation.entities;

import com.ilkhamjumatov.simulation.Coordinate;
import com.ilkhamjumatov.simulation.GameMap;

import java.util.List;
import java.util.Map;

public class Herbivore extends Creature {


    public Herbivore() {
        hp = 90;
        sing = "\uD83D\uDC2E";
    }

    @Override
    public String toString() {
        return sing;
    }

    @Override
    public void makeMove(Coordinate coordinate) {

        List<Coordinate> excludingGrass = GameMap.getExcludingCoordinates(Grass.class);
        List<Coordinate> grassCoordinates = GameMap.getEntityCoordinates(Grass.class);
        List<Coordinate> coordinates = pathFinder.breadthFirstSearch(coordinate, grassCoordinates, excludingGrass);

        if (coordinates == null) {
//            hp -= 30;
        } else if (coordinates.size() == 1) {
            GameMap.entityCoordinateMap.remove(coordinates.get(0));
        } else {
            Coordinate newCoordinate = coordinates.get(0);
            GameMap.entityCoordinateMap.remove(coordinate);
            this.setCoordinate(newCoordinate);
            GameMap.entityCoordinateMap.put(newCoordinate, this);
        }
    }
}
