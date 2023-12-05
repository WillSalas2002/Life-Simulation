package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.*;

import java.util.Map;
import java.util.Random;

public class Action {

    private final Entity[] entities = {new Rock(), new Tree(), new Grass(), new Herbivore(), new Predator()};

    public void initAction(GameMap gameMap) {
        populateMap(gameMap);
    }

    private void populateMap(GameMap gameMap) {

        int rows = gameMap.getRows();
        int columns = gameMap.getColumns();

        for (int i = 0; i < (rows * columns) / 10; i++) {

            Random random = new Random();

            int xRandom = random.nextInt(rows);
            int yRandom = random.nextInt(columns);

            Entity randomEntity = entities[random.nextInt(entities.length)];

            if (!GameMap.entityCoordinateMap.containsKey(new Coordinate(xRandom, yRandom))) {

                GameMap.entityCoordinateMap.put(new Coordinate(xRandom, yRandom), randomEntity);
            }

        }
    }
}
