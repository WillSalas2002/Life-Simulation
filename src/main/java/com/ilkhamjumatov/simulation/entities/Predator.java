package com.ilkhamjumatov.simulation.entities;

import com.ilkhamjumatov.simulation.Coordinate;
import com.ilkhamjumatov.simulation.GameMap;
import java.util.List;

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
    public void makeMove(GameMap gameMap, Coordinate coordinate) {

        List<Coordinate> excludingHerbivore = gameMap.getExcludingCoordinates(Herbivore.class);
        List<Coordinate> herbivoreCoordinates = gameMap.getEntityCoordinates(Herbivore.class);
        List<Coordinate> coordinates = pathFinder.breadthFirstSearch(coordinate, herbivoreCoordinates, excludingHerbivore);

        if (coordinates == null) {
            hp -= 30;
            if (hp <= 0) {
                gameMap.removeEntity(coordinate);
            }
        } else if (coordinates.size() == 1) {
            Herbivore herbivore = (Herbivore) gameMap.getEntityCoordinateMap().get(coordinates.get(0));
            herbivore.hp -= powerOfAttack;

            if (herbivore.hp <= 0) {
                gameMap.removeEntity(coordinates.get(0));
            }

        } else {
            Coordinate newCoordinate = coordinates.get(0);
            gameMap.getEntityCoordinateMap().remove(coordinate);
            this.setCoordinate(newCoordinate);
            gameMap.getEntityCoordinateMap().put(newCoordinate, this);
        }
    }
}
