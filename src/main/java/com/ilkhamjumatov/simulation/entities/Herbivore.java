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
    public void makeMove(GameMap gameMap, Coordinate coordinate) {

        boolean a = (this.coordinate == coordinate);

        List<Coordinate> excludingGrass = gameMap.getExcludingCoordinates(Grass.class);
        List<Coordinate> grassCoordinates = gameMap.getEntityCoordinates(Grass.class);
        List<Coordinate> coordinates = pathFinder.breadthFirstSearch(coordinate, grassCoordinates, excludingGrass);

        if (coordinates == null) {
//            hp -= 30;
//            if (hp <= 0) {
//                GameMap.removeEntity(coordinate);
//            }
        } else if (coordinates.size() == 1) {
            gameMap.removeEntity(coordinates.get(0));
        } else {
            Coordinate newCoordinate = coordinates.get(0);
            gameMap.getEntityCoordinateMap().remove(coordinate);
            this.setCoordinate(newCoordinate);
            gameMap.getEntityCoordinateMap().put(newCoordinate, this);
        }
    }
}
