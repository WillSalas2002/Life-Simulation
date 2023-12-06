package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.*;

import java.util.*;

public class Action {

    private final Entity[] entities = {new Rock(), new Tree(), new Grass(), new Herbivore(), new Predator()};
    private final Random random = new Random();

    public void initAction(GameMap gameMap) {
        populateMap(gameMap);
    }

    public void turnAction() {

        Set<Coordinate> coordinatesOfAllEntities = new HashSet<>(GameMap.entityCoordinateMap.keySet());

        for (Coordinate coordinate : coordinatesOfAllEntities) {

            Entity entity = GameMap.entityCoordinateMap.get(coordinate);

            if (entity instanceof Creature creature) {
                creature.makeMove(coordinate);
            }
        }
    }

    private void populateMap(GameMap gameMap) {

        int rows = gameMap.getRows();
        int columns = gameMap.getColumns();

        for (int i = 0; i < (rows * columns) / 10; i++) {

            int xRandom = random.nextInt(rows);
            int yRandom = random.nextInt(columns);

            Entity randomEntity = entities[random.nextInt(entities.length)];
            Coordinate randomCoordinate = new Coordinate(xRandom, yRandom);

            if (!GameMap.entityCoordinateMap.containsKey(randomCoordinate)) {
                randomEntity.setCoordinate(randomCoordinate);
                GameMap.entityCoordinateMap.put(randomCoordinate, randomEntity);
            }
        }
    }
}
