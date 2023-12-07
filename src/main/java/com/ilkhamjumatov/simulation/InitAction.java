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

        int rows = gameMap.getRows();
        int columns = gameMap.getColumns();

//        Coordinate c1 = new Coordinate(0,0);
//        Entity e1 = new Predator();
//        e1.setCoordinate(c1);
//
//        Coordinate c2 = new Coordinate(0,9);
//        Entity e2 = new Predator();
//        e2.setCoordinate(c2);
//
//        Coordinate c3 = new Coordinate(9,0);
//        Entity e3 = new Herbivore();
//        e3.setCoordinate(c3);
//
//        Coordinate c4 = new Coordinate(9,9);
//        Entity e4 = new Herbivore();
//        e4.setCoordinate(c4);
//
//        Coordinate c5 = new Coordinate(5,5);
//        Entity e5 = new Herbivore();
//        e5.setCoordinate(c5);
//
//        Coordinate c6 = new Coordinate(2,2);
//        Entity e6 = new Grass();
//        e6.setCoordinate(c6);
//
//        gameMap.getEntityCoordinateMap().put(c1,e1);
//        gameMap.getEntityCoordinateMap().put(c2,e2);
//        gameMap.getEntityCoordinateMap().put(c3,e3);
//        gameMap.getEntityCoordinateMap().put(c4,e4);
//        gameMap.getEntityCoordinateMap().put(c5,e5);
//        gameMap.getEntityCoordinateMap().put(c6,e6);

        for (int i = 0; i < (rows * columns) / 10; i++) {

            int xRandom = random.nextInt(rows);
            int yRandom = random.nextInt(columns);

            Coordinate randomCoordinate = new Coordinate(xRandom, yRandom);

            if (!gameMap.getEntityCoordinateMap().containsKey(randomCoordinate)) {
                Entity randomEntity = entities[random.nextInt(entities.length)];
                randomEntity.setCoordinate(randomCoordinate);
                gameMap.addEntity(randomEntity);
                System.out.println(randomEntity.getCoordinate().equals(randomCoordinate));
            }
        }


        for (Map.Entry<Coordinate, Entity> entry : gameMap.getEntityCoordinateMap().entrySet()) {
            Entity entity = entry.getValue();
            Coordinate coordinate = entry.getKey();

            System.out.println(entity + " : " + entity.getCoordinate() + " : " + coordinate);
        }
    }
}
