package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.Creature;
import com.ilkhamjumatov.simulation.entities.Entity;

import java.util.HashSet;
import java.util.Set;

public class TurnAction extends Action {
    @Override
    public void execute(GameMap gameMap) {

        Set<Coordinate> coordinatesOfAllEntities = new HashSet<>(gameMap.getEntityCoordinateMap().keySet());

        for (Coordinate coordinate : coordinatesOfAllEntities) {

            Entity entity = gameMap.getEntityCoordinateMap().get(coordinate);

            if (entity instanceof Creature creature) {
                creature.makeMove(gameMap, coordinate);
            }
        }
    }
}
