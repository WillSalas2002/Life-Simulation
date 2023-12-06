package com.ilkhamjumatov.simulation.entities;

import com.ilkhamjumatov.simulation.Coordinate;
import com.ilkhamjumatov.simulation.GameMap;

import java.util.List;
import java.util.Map;

public class Predator extends Creature {

    private final int powerOfAttack;
    public Predator() {
        hp = 90;
        sing = "\uD83E\uDD81";
        powerOfAttack = 30;
    }

    @Override
    public String toString() {
        return sing;
    }

    @Override
    public void makeMove(Coordinate coordinate) {

        List<Coordinate> coordinates = pathFinder.breadthFirstSearch(coordinate, GameMap.getEntityCoordinates(Herbivore.class), GameMap.getExcludingCoordinates(Herbivore.class));

        if (coordinates == null) {
            hp -= 30;
        } else if (coordinates.size() == 1) {
            Herbivore herbivore = (Herbivore) GameMap.entityCoordinateMap.get(coordinates.get(0));
            herbivore.hp -= 30;

            if (herbivore.hp <= 0) {
                GameMap.entityCoordinateMap.remove(coordinates.get(0));
            }

        } else {
            Coordinate newCoordinate = coordinates.get(0);
            GameMap.entityCoordinateMap.remove(coordinate);
            this.setCoordinate(newCoordinate);
            GameMap.entityCoordinateMap.put(newCoordinate, this);
        }
    }
}
