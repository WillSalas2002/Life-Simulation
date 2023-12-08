package com.ilkhamjumatov.simulation;

import com.ilkhamjumatov.simulation.entities.*;

import java.util.Map;
import java.util.Random;

public class InitAction extends Action {

    private final Entity[] entities = {new Rock(), new Tree(), new Grass(), new Herbivore(), new Predator()};
    private final Random random = new Random();

    @Override
    public void execute(GameMap gameMap) {
        populateMap(gameMap);
    }

    private void populateMap(GameMap gameMap) {

        Predator pr = new Predator();
        pr.setCoordinate(new Coordinate(0,0));
        gameMap.getEntityCoordinateMap().put(new Coordinate(0,0), pr);

        for (int i = 0; i < GameMap.COLUMNS * GameMap.COLUMNS * 0.4; i++) {

            Entity entity = getRandomEntity(entities[random.nextInt(entities.length - 1)].getClass());
            gameMap.addEntity(entity);
        }
    }

    private Entity getRandomEntity(Class<? extends Entity> entityClass) {

        int randomCol = random.nextInt(GameMap.COLUMNS);
        int randomRow = random.nextInt(GameMap.ROWS);

        try {
            Entity entity = entityClass.getConstructor().newInstance();
            entity.setCoordinate(new Coordinate(randomCol, randomRow));

            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
